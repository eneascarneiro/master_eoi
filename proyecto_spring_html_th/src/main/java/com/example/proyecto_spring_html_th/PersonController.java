package com.example.proyecto_spring_html_th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/Calendario")
    String getCalendario(Model model) throws ParseException{
        Calendario miCalendario = new Calendario();
        model.addAttribute("attr_calendario", miCalendario);
        return "calendario";
    }
    @PostMapping("/altaCalendario")
    public String altacalendario(@ModelAttribute("attr_calendario") Calendario calendario){
        // si tuviera rTodo tendría un servicio conectado a una bbdd
        // objetoServicio.save(objetodelectura);
        // En este caso vamos a poner por consola los datos leidos.
        System.out.println(calendario.getTextoAccion());
        return "Calendario";

    }
    @RequestMapping("/createCalendar")
    public String createCalendar(EoiCalendar eoiCalendar){
        // Servicio conectado a la BBDD donde puedo controlar la entrada de datos
        // objetoDeLecturaServicio
        // En este ejemplo mostramos por consola en url indicada
        System.out.println("calendario accion = " + eoiCalendar.getActionText());
        System.out.println("calendario hora = " + eoiCalendar.getActionHora());
        System.out.println("calendario dia = " + eoiCalendar.getActionDia());
        return "Calendar";
    }
}
