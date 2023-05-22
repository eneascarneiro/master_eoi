package com.app.gestionturnos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController  {
    @GetMapping("/pantalladniel")
    public String metodopantalladaniel(){
        return "usuarios/pantalladedaniel";
    }
}
