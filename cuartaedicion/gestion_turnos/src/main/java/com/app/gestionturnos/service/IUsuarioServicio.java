package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
