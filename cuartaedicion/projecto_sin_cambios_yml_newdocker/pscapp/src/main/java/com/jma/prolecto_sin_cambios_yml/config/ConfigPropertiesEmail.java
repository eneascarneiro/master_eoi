package com.jma.prolecto_sin_cambios_yml.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "mailstrap")
public class ConfigPropertiesEmail {
    private String username;
    private String password;
    private String host;
    private String props_mail_smtp_auth;
    private String props_mail_smtp_starttls_enable;
    private String props_mail_smtp_host;
    private String props_mail_smtp_port;
}
