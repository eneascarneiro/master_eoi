package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.model.EtiquetaEmbeddable;
import com.example.jpa_formacion.service.EtiquetaEmbeddableService;
import com.example.jpa_formacion.service.MenuService;
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
public class AppEtiquetaEmbeddableController extends AbstractController<EtiquetaEmbeddable> {

    private final EtiquetaEmbeddableService service;

    public AppEtiquetaEmbeddableController(MenuService menuService, EtiquetaEmbeddableService service) {
        super(menuService);
        this.service = service;
    }


    @GetMapping("/etiquetas/embed")
    public String vistaEtiquetaEmbed(@RequestParam("page") Optional<Integer> page,
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
        Page<EtiquetaEmbeddable> entsLPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));
        System.out.println("numero de registros:" + entsLPage.stream().count());
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(entsLPage));
        interfazConPantalla.addAttribute("listaDtos", entsLPage);
        return "etiquetas/embed/listaetiquetaspagina";
    }

    @GetMapping("/etiquetas/embed/{id}")
    public ModelAndView  vistaDatosEtiqueta(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("etiquetas/embed/edit");
        ModelAndView modelAndViewNoencontrado = new ModelAndView("etiquetas/embed/detallesnoencontrado");

        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaEmbeddable> ent = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (ent.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "UsuarioDto"
            //addAttribute y thymeleaf no  entienden Optional
            EtiquetaEmbeddable attr = ent.get();
            //Asigno atributos y muestro
            modelAndView.addObject("datos",attr);
            return modelAndView;
        } else{
            //Mostrar página usuario no existe
            return modelAndViewNoencontrado;
        }
    }
    @PostMapping("/etiquetas/embed/{id}")
    public String guardarEdicionDatosEnt(@PathVariable("id") Integer id, EtiquetaEmbeddable etiquetaEmbeddable) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaEmbeddable> etiquetaEmbeddableControl = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (etiquetaEmbeddableControl.isPresent()){
            //LLamo al método del servicioi para guardar los datos
            EtiquetaEmbeddable etiquetaEmbeddableGuardar =  new EtiquetaEmbeddable();
            etiquetaEmbeddableGuardar.setId(id);
            etiquetaEmbeddableGuardar.setName(etiquetaEmbeddable.getName());
            //Obtenemos la password del sercio
            this.service.guardar(etiquetaEmbeddableGuardar);
            return String.format("redirect:/etiquetas/embed/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "etiquetas/embed/detallesnoencontrado";
        }
    }

    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/etiquetas/embed/registro")
    public String vistaRegistroEtiqueta(ModelMap interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final EtiquetaEmbeddable etiquetaEmbeddable = new EtiquetaEmbeddable();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", etiquetaEmbeddable);
        return "etiquetas/embed/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/etiquetas/embed/registro")
    public String guardarEtiqueta( EtiquetaEmbeddable ent) throws Exception {
        //LLamo al método del servicioi para guardar los datos
        EtiquetaEmbeddable etiquetaEmbeddable =  this.service.guardar(ent);
        Long id = etiquetaEmbeddable.getId();

        return String.format("redirect:/etiquetas/embed/%s", id);
    }


    @PostMapping("/etiquetas/embed/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaEmbeddable> etiquetaEmbeddable = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (etiquetaEmbeddable.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/etiquetas/embed";
        } else{
            //Mostrar página usuario no existe
            return "etiquetas/embed/detallesnoencontrado";
        }
    }

}
