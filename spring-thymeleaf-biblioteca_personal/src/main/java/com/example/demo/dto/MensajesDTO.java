package com.example.demo.dto;

import java.time.ZonedDateTime;

public class MensajesDTO {
    private Integer id;

    private String mensaje;

    private Integer userId;

    private Integer userId_reciver;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
