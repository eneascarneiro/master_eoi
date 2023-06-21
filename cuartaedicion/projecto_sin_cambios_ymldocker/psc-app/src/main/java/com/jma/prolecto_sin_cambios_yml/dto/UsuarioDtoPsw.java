package com.jma.prolecto_sin_cambios_yml.dto;

import com.jma.prolecto_sin_cambios_yml.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoPsw {
    private long id;

    private String email;

    private String nombreUsuario;

    private String nombreEmail;

    private String password;

    private Set<Role> roles = new HashSet<>();

}
