package com.jma.prolecto_sin_cambios_yml.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCambioPsw {

    private String usuario;

    private String password;

    private String newpassword;


}
