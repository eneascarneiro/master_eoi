/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.infrastructure.security.jwt;

import com.example.infrastructure.security.Authenticated;
import com.example.infrastructure.security.UserInfo;
import io.jsonwebtoken.ExpiredJwtException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hantsy
 */
@RememberMe(
        cookieMaxAgeSecondsExpression ="jwtProperties.remembermeValidityInSeconds" ,
        isRememberMeExpression = "self.isRememberMe(httpMessageContext)"
)
@ApplicationScoped
public class JwtAuthenticationMechanism implements HttpAuthenticationMechanism {
    public static final String AUTHORIZATION_PREFIX = "Bearer ";

    @Inject
    Logger LOGGER;

    /**
     * Access to the IdentityStore(AuthenticationIdentityStore,AuthorizationIdentityStore) is abstracted by the
     * IdentityStoreHandler to allow for multiple identity stores to logically act as a single IdentityStore
     */
    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @Inject
    private TokenProvider tokenProvider;

    @Inject
    @Authenticated
    private Event<UserInfo> authenticatedEvent;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) {

        LOGGER.log(Level.INFO, "validateRequest: {0}, {1}", new Object[]{request.getRequestURI(), request.getMethod()});
        // Get the (caller) name and password from the request
        // NOTE: This is for the smallest possible example only. In practice
        // putting the password in a request query parameter is highly insecure
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String token = extractToken(context);

        if (name != null && password != null
                && "POST".equals(request.getMethod())
                && request.getRequestURI().endsWith("/auth/login")) {
            LOGGER.log(Level.INFO, "user credentials : {0}, {1}", new String[]{name, password});
            // validation of the credential using the identity store
            CredentialValidationResult result = identityStoreHandler.validate(new UsernamePasswordCredential(name, password));
            if (result.getStatus() == CredentialValidationResult.Status.VALID) {
                // Communicate the details of the authenticated user to the container and return SUCCESS.
                return createToken(result, context);
            }
            // if the authentication failed, we return the unauthorized status in the http response
            return context.responseUnauthorized();
        } else if (token != null) {
            // validation of the jwt credential
            return validateToken(token, context);
        } else if (context.isProtected()) {
            // A protected resource is a resource for which a constraint has been defined.
            // if there are no credentials and the resource is protected, we response with unauthorized status
            return context.responseUnauthorized();
        }
        // there are no credentials AND the resource is not protected, 
        // SO Instructs the container to "do nothing"
        return context.doNothing();
    }

    /**
     * To validate the JWT token e.g Signature check, JWT claims check(expiration) etc
     *
     * @param token   The JWT access tokens
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
                JwtCredential credential = tokenProvider.getCredential(token);

                //fire an @Authenticated CDI event.
                authenticatedEvent.fire(new UserInfo(credential.getPrincipal(), credential.getAuthorities()));

                return context.notifyContainerAboutLogin(credential.getPrincipal(), credential.getAuthorities());
            }
            // if token invalid, response with unauthorized status
            return context.responseUnauthorized();
        } catch (ExpiredJwtException eje) {
            LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new String[]{eje.getClaims().getSubject(), eje.getMessage()});
            return context.responseUnauthorized();
        }
    }

    /**
     * Create the JWT using CredentialValidationResult received from IdentityStoreHandler
     *
     * @param result  the result from validation of UsernamePasswordCredential
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus createToken(CredentialValidationResult result, HttpMessageContext context) {
        if (!isRememberMe(context)) {
            String jwt = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), false);
            context.getResponse().setHeader(HttpHeaders.AUTHORIZATION, AUTHORIZATION_PREFIX + jwt);
        }

        //fire an @Authenticated CDI event.
        authenticatedEvent.fire(new UserInfo(result.getCallerPrincipal().getName(), result.getCallerGroups()));

        return context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
    }

    /**
     * To extract the JWT from Authorization HTTP header
     *
     * @param context
     * @return The JWT access tokens
     */
    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith(AUTHORIZATION_PREFIX)) {
            String token = authorizationHeader.substring(AUTHORIZATION_PREFIX.length());
            return token;
        }
        return null;
    }

    /**
     * this function invoked using RememberMe.isRememberMeExpression EL expression
     *
     * @param context
     * @return The remember me flag
     */
    public Boolean isRememberMe(HttpMessageContext context) {
        return Boolean.valueOf(context.getRequest().getParameter("rememberMe"));
    }

}
