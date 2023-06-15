package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.EtiquetaDtoApi;
import com.example.jpa_formacion.dto.UsuarioDto;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.service.EtiquetaService;
import com.example.jpa_formacion.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etiquetas")
public class APIEtiquetaController extends AbstractController<EtiquetaDto> {

    private final EtiquetaService service;

    public APIEtiquetaController(MenuService menuService, EtiquetaService service) {
        super(menuService);
        this.service = service;
    }


    @GetMapping("")
    public ResponseEntity<List<EtiquetaDtoApi>> listaetiquetas(){

        //Obetenemos el objeto Page del servicio
        List<EtiquetaDtoApi> etiquetaDtoApis = service.buscartodosapi();


        //Respuesta con el json
        //gestionar las respuestas
        if (etiquetaDtoApis.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //hay registros
        return new ResponseEntity<>(etiquetaDtoApis, HttpStatus.OK);
    }



}