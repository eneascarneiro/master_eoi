package com.example.jpa_formacion.web.controller;


import com.example.jpa_formacion.dto.ClienteDto;
import com.example.jpa_formacion.dto.EmpleadoDto;
import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.GaleriaDto;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AppGaleriaController extends AbstractController<GaleriaDto> {
    private final GaleriaService service;
    private EmpleadoService empleadoService;

    private EtiquetaService etiquetaService;


    public AppGaleriaController(MenuService menuService,GaleriaService service, EmpleadoService empleadoService, EtiquetaService etiquetaService) {
        super(menuService);
        this.service = service;
        this.empleadoService = empleadoService;
        this.etiquetaService = etiquetaService;
    }


    @GetMapping("/galeria")
    public String vista( Model interfazConPantalla){
        Set<GaleriaDto>  galeriaDtos = service.buscarTodosSet();
        interfazConPantalla.addAttribute("listacatalogo", galeriaDtos);
        return "galeria/mokupCatalogo";
    }

    @GetMapping("/galeria/{id}")
    public String vistaDatosGaleria(@PathVariable("id") Integer id, ModelMap interfazConPantalla){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            //Obtenemos el listado de empleados
            List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
            //Como encontré datos, obtengo el objerto de tipo "GaleriaDto"
            //addAttribute y thymeleaf no  entienden Optional
            GaleriaDto attr = dto.get();
            //Como recorrer la galeria y sus datos

            //Asigno atributos y muestro
            interfazConPantalla.addAttribute("datos",attr);
            interfazConPantalla.addAttribute("listaEmpleados",empleadoDtoList);
            return "galeria/edit";
        } else{
            //Mostrar página usuario no existe
            return "galeria/detallesnoencontrado";
        }
    }
    //Me falta un postmaping para guardar
    @PostMapping("/galeria/{id}")
    public String guardarEdicionDatosGaleria(@PathVariable("id") Integer id, GaleriaDto dtoEntrada) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaDto> dtoControl = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dtoControl.isPresent()){
            this.service.guardar(dtoEntrada);
            return String.format("redirect:/galeria/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "galeria/detallesnoencontrado";
        }
    }

    @PostMapping("/galeria/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/galeria";
        } else{
            //Mostrar página usuario no existe
            return "galeria/detallesnoencontrado";
        }
    }

    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/galeria/registro")
    public String vistaRegistroGaleria(Model interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final GaleriaDto galeriaDto = new GaleriaDto();
        //Obtenemos el listado de empleados
        List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
        //obtengo la lista de etiquetas entidades!!!!!!
        List<Etiqueta>  etiquetasList = this.etiquetaService.buscarEntidades();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", galeriaDto);
        interfazConPantalla.addAttribute("listaEmpleados",empleadoDtoList);
        interfazConPantalla.addAttribute("listaEtiquetas",etiquetasList);
        return "galeria/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/galeria/registro")
    public String guardarEtiqueta(@ModelAttribute("datos") GaleriaDto dto) throws Exception {
        System.out.println("Etiquetas gyardadas:" + dto.getEtiquetas().stream().count());
        System.out.println("Etiquetas conenido:" + dto.getEtiquetas());
        //LLamo al método del servicioi para guardar los datos
        GaleriaDto galeriaDtod =  this.service.guardar(dto);
        //Gestionar la asignación del empleado
        System.out.println("Etiquetas galeriaDtod :" + galeriaDtod.getEtiquetas().stream().count());
        System.out.println("Etiquetas galeriaDtod conenido:" + galeriaDtod.getEtiquetas());
        //Gestionar la asignación de etiquetas
        Long id = galeriaDtod.getId();
        return String.format("redirect:/galeria/%s", id);
    }

}
