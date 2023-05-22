package com.app.gestionturnos.dto;

import com.app.gestionturnos.model.Role;
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
public class UsuarioDto {
    private long id;

    private String email;

    private String nombreUsuario;

    private String nombreEmail;

    private Set<Role> roles = new HashSet<>();
}
