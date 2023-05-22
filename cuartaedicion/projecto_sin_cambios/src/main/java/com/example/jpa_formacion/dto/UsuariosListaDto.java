package com.example.jpa_formacion.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuariosListaDto {
    //Necesito una lista de usuarioDTO a manejar para la edición multiple
    List<UsuarioDto> usuarioDtos;
    //Constructores
    public UsuariosListaDto(List<UsuarioDto> usuarioDtos) {
        this.usuarioDtos = usuarioDtos;
    }
    public UsuariosListaDto(){
        this.usuarioDtos = new ArrayList<>();
    }
    //getter and setter

    public List<UsuarioDto> getUsuarioDtos() {
        return usuarioDtos;
    }

    public void setUsuarioDtos(List<UsuarioDto> usuarioDtos) {
        this.usuarioDtos = usuarioDtos;
    }
    //Metodo para añadir registros a la lista
    public void anadirUsuarios(UsuarioDto usuarioDto){
        this.usuarioDtos.add(usuarioDto);
    }
}
