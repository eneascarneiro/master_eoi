package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
