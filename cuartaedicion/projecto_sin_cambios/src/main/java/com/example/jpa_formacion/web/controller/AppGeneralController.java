package com.example.jpa_formacion.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppGeneralController  {
    @GetMapping("/pantallaalba")
    public String metodopantallaalba(){
        return "usuarios/pantalladealba";
    }
    @GetMapping("/pantallaadrian")
    public String metodopantallaadrian(){
        return "usuarios/paginadeadrian";
    }

}
