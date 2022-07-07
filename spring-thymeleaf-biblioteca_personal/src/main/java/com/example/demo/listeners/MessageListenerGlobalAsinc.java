package com.example.demo.listeners;

import com.example.demo.event.MessageEvent;
import com.example.demo.event.MessageEventSaludo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerGlobalAsinc {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerGlobalAsinc.class);

    @EventListener
    @Async
    public void EscucharSaludoAsinc(MessageEventSaludo event) {

            logger.info("El mensaje(MessageEventSaludo) asincrono es: " + event.getMessage() + ", viene de:" + event.getSource() +
                    " y ha llegado a la hora:" + event.getTimestamp());

    }
    @EventListener
    @Async
    public void EscucharMensajeAsinc(MessageEvent eventmensaje) {

        logger.info("El mensaje(MessageEvent) asincrono es: " + eventmensaje.getMessage() + ", viene de:" + eventmensaje.getSource() +
                " y ha llegado a la hora:" + eventmensaje.getTimestamp());

    }
}
