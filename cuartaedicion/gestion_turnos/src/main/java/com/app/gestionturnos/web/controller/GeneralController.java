package com.app.gestionturnos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class GeneralController  {
    @GetMapping("/pantalladniel")
    public String metodopantalladaniel(){
        return "usuarios/pantalladedaniel";
    }

    @GetMapping("/pantallaalba")
    public String metodopantallaalba( ModelMap interfazConPantalla){
        interfazConPantalla.addAttribute("titulo","Pantalla de alba");

        return "usuarios/pantalladedaniel";
    }
}
