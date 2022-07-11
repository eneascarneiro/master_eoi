package com.example.demo.event;

import org.springframework.context.ApplicationEvent;
import com.example.demo.dto.MensajesDTO;

public class MessageEventSaludo extends ApplicationEvent {
    private static final long serialVersionUID = -3762610544324295353L;
    private final MensajesDTO mensajesDTO;

    public MessageEventSaludo(Object source, MensajesDTO mensajesDTO) {
        super(source);
        this.mensajesDTO = mensajesDTO;
    }
    public MensajesDTO getMessage() {
        return mensajesDTO;
    }
}
