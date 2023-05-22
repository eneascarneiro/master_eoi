package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.model.Empresa;
import com.app.gestionturnos.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/oficina")
public class APIEmpresaController {

    @Autowired
    EmpresaRepository Empresa;
    @GetMapping("/listaoficinas")
    public ResponseEntity<List<com.app.gestionturnos.model.Empresa>> getAllOficinas(){
        try {
            //generamos el contenedor
            List<Empresa> oficinas = new ArrayList<>();

            //Leemos dentro del array el contenido del modelo virtual desde el repositorio
            Empresa.findAll().forEach(oficinas::add);
            //el que quiere puede codificar un bucle con iteradores sobre  el resultado de oficinaRepository.findAll()

            //gestionar las respuestas
            if (oficinas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //hay registros
            return new ResponseEntity<>(oficinas, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
