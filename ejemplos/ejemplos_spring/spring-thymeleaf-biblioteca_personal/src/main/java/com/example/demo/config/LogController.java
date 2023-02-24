package com.example.demo.config;

import com.example.demo.listeners.MessageListenerGlobalAsinc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LogController  {
    @Autowired
    ConfigBean configBean;
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerGlobalAsinc.class);

    public void  EscribirLog(Class cl, String messaje,String  content, String tipo){
        switch(tipo){
            case "trace":
                logger.trace("A TRACE Message in class :" + cl.getName() + ", with content:" + messaje + ":" +  content);
                break;
            case "debug":
                logger.debug("A DEBUG  Message in class :" + cl.getName() + ", with content:" + messaje  + ":" +  content);
                break;
            case "info":
                logger.info("An INFO  Message in class :" + cl.getName() + ", with content:" + messaje  + ":" +  content);
                break;
            case "warn":
                logger.warn("An warn  Message in class :" + cl.getName() + ", with content:" + messaje  + ":" +  content);
                break;
            case "error":
                logger.error("An error  Message in class :" + cl.getName() + ", with content:" + messaje  + ":" +  content);

        }

    }

}
