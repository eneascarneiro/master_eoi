package com.example.demo.listeners;

import com.example.demo.data.entity.BooksRead;
import com.example.demo.event.MessageEvent;
import com.example.demo.event.MessageEventSaludo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerVariosEventoALaVez {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerVariosEventoALaVez.class);

    @EventListener({MessageEvent.class, MessageEventSaludo.class,})
    public void EscuchoEventos() {
            logger.info("El ha llegado un evento y no se cual es");
    }
}
