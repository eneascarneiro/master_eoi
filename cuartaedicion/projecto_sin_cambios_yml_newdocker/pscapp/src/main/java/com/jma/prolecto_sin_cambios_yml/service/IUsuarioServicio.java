package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.Usuario;

public interface IUsuarioServicio {
    public String getEncodedPassword(Usuario usuario);
}
