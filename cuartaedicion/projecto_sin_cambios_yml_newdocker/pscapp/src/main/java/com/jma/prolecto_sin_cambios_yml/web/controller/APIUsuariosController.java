package com.jma.prolecto_sin_cambios_yml.web.controller;

import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDto;
import com.jma.prolecto_sin_cambios_yml.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class APIUsuariosController {
    private final UsuarioService service;

    public APIUsuariosController(UsuarioService service) {
        this.service = service;
    }
    @GetMapping("")
    public  ResponseEntity<List<UsuarioDto>>  vistaUsuarios( ){
        //tenemos que leer la lista de usuarios
        //Que elemento me la ofrece?
        //listaUsrTodos
        List<UsuarioDto> lusrdto = this.service.buscarTodos();
        //Respuesta con el json
        //gestionar las respuestas
        if (lusrdto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //hay registros
        return new ResponseEntity<>(lusrdto, HttpStatus.OK);
    }
}
