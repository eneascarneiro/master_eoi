package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.model.EtiquetaEmbeddable;
import com.example.jpa_formacion.model.TablaIzqEmbeddable;
import com.example.jpa_formacion.service.EtiquetaEmbeddableService;
import com.example.jpa_formacion.service.MenuService;
import com.example.jpa_formacion.service.TablaIzqEmbeddableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TablaIzqEmbeddableController extends AbstractController<TablaIzqEmbeddable> {

    private final TablaIzqEmbeddableService service;

    public TablaIzqEmbeddableController(MenuService menuService, TablaIzqEmbeddableService service) {
        super(menuService);
        this.service = service;
    }


    @GetMapping("/mnembedizq/list")
    public String listadatos(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                    ModelMap interfazConPantalla){

        //Obetenemos el objeto Page del servicio
        Integer pagina = 0;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        Page<TablaIzqEmbeddable> entsLPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));
        System.out.println("numero de registros:" + entsLPage.stream().count());
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(entsLPage));
        interfazConPantalla.addAttribute("listaDtos", entsLPage);
        return "mnembedizq/listapagina";
    }

    @GetMapping("/mnembedizq/{id}")
    public ModelAndView  vistaDatos(@PathVariable("id") Long id){
        //Defino la pagina a pintar
        ModelAndView modelAndView = new ModelAndView("mnembedizq/edit");
        //Defino pagina no hay datos
        ModelAndView modelAndViewNoencontrado = new ModelAndView("mnembed/detallesnoencontrado");

        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<TablaIzqEmbeddable> ent = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (ent.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "UsuarioDto"
            //addAttribute y thymeleaf no  entienden Optional
            TablaIzqEmbeddable attr = ent.get();
            //Asigno atributos y muestro
            modelAndView.addObject("datos",attr);
            return modelAndView;
        } else{
            //Mostrar página usuario no existe
            return modelAndViewNoencontrado;
        }
    }
    @PostMapping("/mnembedizq/{id}")
    public String guardarEdicionDatosEnt(@PathVariable("id") Long id, TablaIzqEmbeddable ent) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<TablaIzqEmbeddable> entcrontrol = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (entcrontrol.isPresent()){
            //LLamo al método del servicioi para guardar los datos
            TablaIzqEmbeddable etiquetaEmbeddableGuardar =  new TablaIzqEmbeddable();
            etiquetaEmbeddableGuardar.setId(id);
            etiquetaEmbeddableGuardar.setDescripcion(ent.getDescripcion());
            //Obtenemos la password del sercio
            this.service.guardar(etiquetaEmbeddableGuardar);
            return String.format("redirect:/mnembedizq/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "mnembedizq/detallesnoencontrado";
        }
    }

    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/mnembedizq/registro")
    public String vistaRegistro(ModelMap interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final TablaIzqEmbeddable ent = new TablaIzqEmbeddable();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", ent);
        return "mnembedizq/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/mnembedizq/registro")
    public String guardarEtiqueta( TablaIzqEmbeddable ent) throws Exception {
        //LLamo al método del servicioi para guardar los datos
        TablaIzqEmbeddable entguardar =  this.service.guardar(ent);
        Long id = entguardar.getId();
        return String.format("redirect:/mnembedizq/%s", id);
    }


    @PostMapping("/mnembedizq/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Long id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<TablaIzqEmbeddable> ent = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (ent.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/mnembedizq";
        } else{
            //Mostrar página usuario no existe
            return "mnembedizq/detallesnoencontrado";
        }
    }

}
