package com.example.demo.config;

import com.example.demo.web.access.expression.CustomWebSecurityExpressionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.ConsensusBased;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomAuthorizationConfig {

    @Description("ConsensusBased AccessDecisionManager for Authorization voting")
    @Bean
    public AccessDecisionManager accessDecisionManager(
            CustomWebSecurityExpressionHandler customWebSecurityExpressionHandler) {
        List<AccessDecisionVoter<? extends Object>> decisionVoters
                = Arrays.asList(
                new WebExpressionVoter() {{
                    setExpressionHandler(customWebSecurityExpressionHandler);
                }}
        );
        return new ConsensusBased(decisionVoters);
    }
}