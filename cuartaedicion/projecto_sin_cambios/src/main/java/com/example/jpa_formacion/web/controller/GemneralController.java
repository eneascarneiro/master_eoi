package com.example.jpa_formacion.web.controller;


import com.example.jpa_formacion.util.FileUploadUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SessionAttributes("app")
@Controller
public class GemneralController {


    public GemneralController() {
        super();
    }


    @GetMapping("/upload")
    public String vistaGet( ){

        return "upload/upload";
    }
    @GetMapping("/usuarios")
    public String vistaGet( ){

        return "usuarios/listausuariospagina";
    }

}
