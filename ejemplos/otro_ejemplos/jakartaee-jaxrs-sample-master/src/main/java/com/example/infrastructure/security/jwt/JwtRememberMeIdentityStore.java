/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.infrastructure.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.RememberMeCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.RememberMeIdentityStore;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

/**
 *
 * @author hantsy
 */
@ApplicationScoped
public class JwtRememberMeIdentityStore implements RememberMeIdentityStore {

    @Inject
    private Logger LOGGER ;

    @Inject
    private TokenProvider tokenProvider;

    @Override
    public CredentialValidationResult validate(RememberMeCredential rememberMeCredential) {
        try {
            if (tokenProvider.validateToken(rememberMeCredential.getToken())) {
                JwtCredential credential = tokenProvider.getCredential(rememberMeCredential.getToken());
                return new CredentialValidationResult(credential.getPrincipal(), credential.getAuthorities());
            }
            // if token invalid, response with invalid result status
            return INVALID_RESULT;
        } catch (ExpiredJwtException eje) {
            LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new Object[]{eje.getClaims().getSubject(), eje.getMessage()});
            return INVALID_RESULT;
        }
    }

    @Override
    public String generateLoginToken(CallerPrincipal callerPrincipal, Set<String> groups) {
        return tokenProvider.createToken(callerPrincipal.getName(), groups, true);
    }

    @Override
    public void removeLoginToken(String token) {
        // Stateless authentication means at server side we don't maintain the state
    }

}
