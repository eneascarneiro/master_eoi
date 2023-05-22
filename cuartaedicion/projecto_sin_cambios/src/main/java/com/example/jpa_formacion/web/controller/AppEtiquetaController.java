package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.*;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.service.EtiquetaService;
import com.example.jpa_formacion.service.MenuService;
import com.example.jpa_formacion.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AppEtiquetaController extends AbstractController<EtiquetaDto> {

    private final EtiquetaService service;

    public AppEtiquetaController(MenuService menuService, EtiquetaService service) {
        super(menuService);
        this.service = service;
    }


    @GetMapping("/etiquetas")
    public String vistaUsuarios(@RequestParam("page") Optional<Integer> page,
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
        Page<EtiquetaDto> dtosLPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));
        System.out.println("numero de registros:" + dtosLPage.stream().count());
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(dtosLPage));
        interfazConPantalla.addAttribute("listaDtos", dtosLPage);
        return "etiquetas/listaetiquetaspagina";
    }

    @GetMapping("/etiquetas/{id}")
    public ModelAndView  vistaDatosEtiqueta(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("etiquetas/edit");
        ModelAndView modelAndViewNoencontrado = new ModelAndView("etiquetas/detallesnoencontrado");

        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "UsuarioDto"
            //addAttribute y thymeleaf no  entienden Optional
            EtiquetaDto attr = dto.get();
            //Asigno atributos y muestro
            modelAndView.addObject("datos",attr);
            return modelAndView;
        } else{
            //Mostrar página usuario no existe
            return modelAndViewNoencontrado;
        }
    }
    @PostMapping("/etiquetas/{id}")
    public String guardarEdicionDatosUsuario(@PathVariable("id") Integer id, EtiquetaDto etiquetaDto) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaDto> etiquetaDtoControl = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (etiquetaDtoControl.isPresent()){
            //LLamo al método del servicioi para guardar los datos
            EtiquetaDto etiqquetaDtoGuardar =  new EtiquetaDto();
            etiqquetaDtoGuardar.setId(id);
            etiqquetaDtoGuardar.setName(etiquetaDto.getName());
            //Obtenemos la password del sercio
            this.service.guardar(etiqquetaDtoGuardar);
            return String.format("redirect:/etiquetas/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "etiquetas/detallesnoencontrado";
        }
    }



    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/etiquetas/registro")
    public String vistaRegistroEtiqueta(ModelMap interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final EtiquetaDto etiquetaDto = new EtiquetaDto();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", etiquetaDto);
        return "etiquetas/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/etiquetas/registro")
    public String guardarEtiqueta( EtiquetaDto dto) throws Exception {
        //LLamo al método del servicioi para guardar los datos
        EtiquetaDto etiquetaDto =  this.service.guardar(dto);
        Long id = etiquetaDto.getId();

        return String.format("redirect:/etiquetas/%s", id);
    }


    @PostMapping("/etiquetas/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<EtiquetaDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/etiquetas";
        } else{
            //Mostrar página usuario no existe
            return "etiquetas/detallesnoencontrado";
        }
    }

}
