package com.example.demo.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.*;

@Component
public class ConfigBean  {
    @Value("${usrName}")
    private  String usrName;
    @Value("${dbname}")
    private  String dbname;
    @Value("${spring.test.cloud}")
    private  String springtestcloud;
    @Value("${otro.properties.otro}")
    private  String otro;
    private  String usrNameLC;
    @Value("${app.properties.classpath}")
    private String classpath;
    @Value("${app.properties.external}")
    private String external;

    @Value("${app.properties.argument}")
    private String argument;

    @Value("${app.properties.environment}")
    private String environment;

    @Value("${app.properties.cloud}")
    private String cloud;


    public String getUsrName() {
        return usrName;
    }

    public String getDbname() {
        return dbname;
    }

    public String getClasspath() {
        return classpath;
    }

    public String getExternal() {
        return external;
    }

    public String getArgument() {
        return argument;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getUsrNameLC() {
        return usrNameLC;
    }

    public void setUsrNameLC(String usrNameLC) {
        this.usrNameLC = usrNameLC;
    }

    public String getCloud() {
        return cloud;
    }

    public String getSpringtestcloud() {
        return springtestcloud;
    }

    public String getOtro() {
        return otro;
    }
}
