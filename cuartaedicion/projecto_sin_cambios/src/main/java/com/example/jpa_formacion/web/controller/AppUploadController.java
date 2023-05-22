package com.example.jpa_formacion.web.controller;



import com.example.jpa_formacion.util.FileUploadUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SessionAttributes("productos")
@Controller
public class AppUploadController  {


    public AppUploadController() {
        super();
    }


    @GetMapping("/upload")
    public String vistaGet( ){

        return "upload/upload";
    }


    @PostMapping("/upload")
    public String uploadPost(@RequestParam MultipartFile file, HttpSession session , Model model) throws IOException {
        String path=session.getServletContext().getRealPath("/");
        String filename=file.getOriginalFilename();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());


        String uploadDir = "src/main/resources/static/files/";

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        model.addAttribute("file",file);
        //return new ModelAndView("upload/fileUploadView","filename",path+"/"+filename);
        return "upload/fileUploadViewUno";
    }
    @GetMapping("/uploadimg")
    public String vistaGetImg( ){

        return "upload/uploadimg";
    }
    @PostMapping("/uploadimg")
    public String uploadImgPost(@RequestParam MultipartFile file, HttpSession session , Model model) throws IOException {
        String path=session.getServletContext().getRealPath("/");
        String filename=file.getOriginalFilename();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());


        String uploadDir = "src/main/resources/static/imagenes/";

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        model.addAttribute("file",file);
        //return new ModelAndView("upload/fileUploadView","filename",path+"/"+filename);
        return "upload/fileUploadViewUno";
    }
}
