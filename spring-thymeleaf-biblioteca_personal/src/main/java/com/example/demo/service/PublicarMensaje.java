package com.example.demo.service;
import com.example.demo.dto.MensajesDTO;
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

    public void  EnviarMensajeEvento(String mensaje){
        logger.info("Inicio el envío de mensaje por eventos");
        MessageEvent messageEvent = new MessageEvent(this,mensaje);
        publisher.publishEvent(messageEvent);
        logger.info("Evento generado");

    }
    public void  EnviarMensajeSaludo(MensajesDTO mensajesDTO){
        logger.info("Inicio el envío de mensaje saludo por eventos");
        MessageEventSaludo messageEventSaludo = new MessageEventSaludo(this,mensajesDTO);
        publisher.publishEvent(messageEventSaludo);
        logger.info("Evento generado de saludo");

    }

}
