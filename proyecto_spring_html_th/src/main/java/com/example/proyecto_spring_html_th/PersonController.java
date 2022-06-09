package com.example.proyecto_spring_html_th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping("/Person")
    String getPerson(Model model) throws ParseException {
        String sDate1="31/12/1998";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Person miPerson = new Person("Luis", "Perez",
                "st.depositphotos.com/1020341/4233/i/950/depositphotos_42333899-stock-photo-portrait-of-huge-beautiful-male.jpg",
                "Calle las rondas 27",formatter1.parse(sDate1));
        model.addAttribute("persona",miPerson);
        //Generamos un array (lista con thymeleaf)
        model.addAttribute("personas", Arrays.asList(
            new Person("Luis", "Perez",
                    "st.depositphotos.com/1020341/4233/i/950/depositphotos_42333899-stock-photo-portrait-of-huge-beautiful-male.jpg",
                    "Calle las rondas 27",formatter1.parse("25/03/1972")),
            new Person("Carmen", "Perez",
                    "st.depositphotos.com/1020341/4233/i/950/depositphotos_42333899-stock-photo-portrait-of-huge-beautiful-male.jpg",
                    "Calle las rondas 27",formatter1.parse("25/03/1977")),
            new Person("JuanJo", "Cobos Perez",
                    "st.depositphotos.com/1020341/4233/i/950/depositphotos_42333899-stock-photo-portrait-of-huge-beautiful-male.jpg",
                    "Calle las rondas 28",formatter1.parse("25/03/1999"))

        ));

        return "Person";
    }

    @GetMapping("/")
    String getHome(Model model) throws ParseException {
        Home miHome = new Home("Esta entrando en el home de mi pagina");
        //Ahora preparo el envío de datos
        model.addAttribute("datoshome",miHome);
        return "index";
    }
}
