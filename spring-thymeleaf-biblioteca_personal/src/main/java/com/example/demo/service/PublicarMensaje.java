package com.example.demo.service;
import com.example.demo.event.MessageEvent;
import com.example.demo.event.MessageEventSaludo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PublicarMensaje {
    private static final Logger logger = LoggerFactory.getLogger(PublicarMensaje.class);

    private final ApplicationEventPublisher publisher;

    public PublicarMensaje(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void  EnviarMensajeEvento(){
        logger.info("Inicio el envío de mensaje por eventos");
        MessageEvent messageEvent = new MessageEvent(this,"Mensaje estandar");
        publisher.publishEvent(messageEvent);
        logger.info("Evento generado");

    }
    public void  EnviarMensajeSaludo(){
        logger.info("Inicio el envío de mensaje saludo por eventos");
        MessageEventSaludo messageEventSaludo = new MessageEventSaludo(this,"Hola me escuchas?");
        publisher.publishEvent(messageEventSaludo);
        logger.info("Evento generado de saludo");

    }

}
