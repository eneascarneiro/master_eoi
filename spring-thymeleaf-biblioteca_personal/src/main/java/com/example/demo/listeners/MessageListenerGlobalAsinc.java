package com.example.demo.listeners;

import com.example.demo.data.entity.User;
import com.example.demo.event.MessageEvent;
import com.example.demo.event.MessageEventSaludo;
import com.example.demo.service.MensajesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerGlobalAsinc {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerGlobalAsinc.class);
    private final MensajesService service;

    public MessageListenerGlobalAsinc(MensajesService service) {
        this.service = service;
    }

    @EventListener
    @Async
    public void EscucharSaludoAsinc(MessageEventSaludo event) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        logger.info("El usuario : " + user.getUserName()  + " ha recibido el mensaje(MessageEventSaludo) asincrono es: " + event.getMessage().getMensaje() + ", viene de:" + event.getSource() +
                " y ha llegado a la hora:" + event.getTimestamp());
        //Grabar mensaje para el que envía
        this.service.save(event.getMessage());
        //Grabar mensaje para el que recibe
        this.service.save(event.getMessage(),1);
    }
    @EventListener
    @Async
    public void EscucharMensajeAsinc(MessageEvent eventmensaje) {

        logger.info("El mensaje(MessageEvent) asincrono es: " + eventmensaje.getMessage() + ", viene de:" + eventmensaje.getSource() +
                " y ha llegado a la hora:" + eventmensaje.getTimestamp());

    }
}
