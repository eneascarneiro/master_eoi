package com.example.demo.listeners;

import com.example.demo.event.MessageEvent;
import com.example.demo.event.MessageEventSaludo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerGlobal {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerGlobal.class);

    @EventListener
    public void EscucharSaludo(MessageEventSaludo event) {

            logger.info("El mensaje es: " + event.getMessage().getMensaje() + ", viene de:" + event.getSource() +
                    " y ha llegado a la hora:" + event.getTimestamp());

    }
    @EventListener
    public void EscucharMensaje(MessageEvent eventmensaje) {

        logger.info("El mensaje es: " + eventmensaje.getMessage() + ", viene de:" + eventmensaje.getSource() +
                " y ha llegado a la hora:" + eventmensaje.getTimestamp());

    }
}
