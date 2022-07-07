package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    private static final long serialVersionUID = -3762610544324295353L;
    private final String message;

    public MessageEvent(Object source,String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
