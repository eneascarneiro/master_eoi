package com.example.demo.listeners;

import com.example.demo.event.MessageEvent;
import com.example.demo.service.PublicarMensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener implements ApplicationListener<MessageEvent> {
    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Override
    public void onApplicationEvent(MessageEvent event) {

            logger.info("El mensaje es: " + event.getMessage() + ", viene de:" + event.getSource() +
                    " y ha llegado a la hora:" + event.getTimestamp());

    }
}
