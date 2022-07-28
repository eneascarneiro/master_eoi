package com.example.demo;

import com.example.demo.config.ConfigBean;
import com.example.demo.config.LogController;
import com.example.demo.listeners.MessageListenerGlobalAsinc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class DemoApplication implements ApplicationRunner   {
    @Autowired
    ConfigBean configBean;
    @Autowired
    LogController logController;
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logController.EscribirLog(this.getClass(),"Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()),"info");
        logController.EscribirLog(this.getClass(),"NonOptionArgs: {}", String.valueOf(args.getNonOptionArgs()),"info");
        logController.EscribirLog(this.getClass(),"OptionNames: {}", String.valueOf(args.getOptionNames()),"info");


        if (args.containsOption("usrName")){
            configBean.setUsrNameLC( args.getOptionValues("usrName").toString());
        }
        logController.EscribirLog(DemoApplication.class, "Mensaje de prueba","","info");
        logController.EscribirLog(DemoApplication.class, "Mensaje de prueba","","debug");
        System.out.println("Application yaml classpath property: " + configBean.getClasspath() );
        System.out.println("Application yaml external property: " + configBean.getExternal());
        System.out.println("Application yaml argument property: " + configBean.getArgument());
        System.out.println("Application yaml environment property: " + configBean.getEnvironment());
        System.out.println("Application yaml Cloud property: " + configBean.getCloud());
        System.out.println("Application yaml springtestcloud property: " + configBean.getSpringtestcloud());
        System.out.println("Application yaml otro property: " + configBean.getOtro());

        System.out.println("Application properties usrName property: " + configBean.getUsrName());
        System.out.println("Application properties dbname property: " + configBean.getDbname());
        System.out.println("Application properties logLevel property: " + configBean.getDbname());
        System.out.println("Application properties usrNameLC property: " + configBean.getUsrNameLC());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
}
