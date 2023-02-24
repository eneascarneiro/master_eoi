package com.example.demo.config;

import com.example.demo.service.security.CustomUserAuthenticationProvider;
import com.example.demo.web.access.expression.CustomWebSecurityExpressionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@Import({ CustomAuthorizationConfig.class })
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserAuthenticationProvider authenticationProvider;
    private final AccessDecisionManager accessDecisionManager;
    private final CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler;

    @Autowired
    public SecurityConfig(CustomUserAuthenticationProvider authenticationProvider,
            AccessDecisionManager accessDecisionManager,
            CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler) {
        this.authenticationProvider = authenticationProvider;
        this.accessDecisionManager = accessDecisionManager;
        this.customWebSecurityExpressionHandler = customWebSecurityExpressionHandler;
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // Access Decision Manager:
        http.authorizeRequests().accessDecisionManager(accessDecisionManager)
                // Web Expression Handler:
                .expressionHandler(customWebSecurityExpressionHandler);

        // Login
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll();

        // Logout
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .permitAll();

        // CSRF is enabled by default, with Java Config
        http.csrf().disable()
                // Enable <frameset> in order to use H2 web console
                .headers().frameOptions().disable();

        // Matchers
        http.authorizeRequests()
                .antMatchers("/admin/*").hasAnyRole("ROLE_ADMIN")
                .antMatchers("/login/*").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers( "/api/*").authenticated()
                .antMatchers("/home").permitAll()
                .antMatchers("/wellcome").permitAll()
                .antMatchers("/landing").permitAll()

        ;
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        // Ignore static resources and webjars from Spring Security
        web.ignoring()
                .antMatchers("/js/**")
                .antMatchers("/img/**")
                .antMatchers("/css/**")
                .antMatchers("/fonts/**");
    }
}
