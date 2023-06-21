package com.jma.prolecto_sin_cambios_yml.web.controller;


import com.jma.prolecto_sin_cambios_yml.dto.EmpleadoDto;
import com.jma.prolecto_sin_cambios_yml.dto.GaleriaEmbeddableDto;
import com.jma.prolecto_sin_cambios_yml.model.*;
import com.jma.prolecto_sin_cambios_yml.service.*;
import com.jma.prolecto_sin_cambios_yml.model.*;
import com.jma.prolecto_sin_cambios_yml.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZonedDateTime;
import java.util.*;

@Controller
public class AppGaleriaEmbeddableController extends AbstractController<GaleriaEmbeddable> {
    private final GaleriaEmbeddableService service;
    private EmpleadoService empleadoService;

    private EtiquetaEmbeddableService etiquetaService;

    private GaleriaEtiquetaEmbeddableService galeriaEtiquetaEmbeddableService;



    public AppGaleriaEmbeddableController(MenuService menuService, GaleriaEmbeddableService service
                                            , EmpleadoService empleadoService
                                            , EtiquetaEmbeddableService etiquetaService
                                            , GaleriaEtiquetaEmbeddableService galeriaEtiquetaEmbeddableService
    ) {
        super(menuService);
        this.service = service;
        this.empleadoService = empleadoService;
        this.etiquetaService = etiquetaService;
        this.galeriaEtiquetaEmbeddableService = galeriaEtiquetaEmbeddableService;
    }


    @GetMapping("/galeria/embed")
    public String vista( Model interfazConPantalla){
        Set<GaleriaEmbeddable>  galeriaEmbeddables = service.buscarTodosSet();
        interfazConPantalla.addAttribute("listacatalogo", galeriaEmbeddables);
        return "galeria/embed/mokupCatalogo";
    }

    @GetMapping("/galeria/embed/{id}")
    public String vistaDatosGaleria(@PathVariable("id") Integer id, ModelMap interfazConPantalla){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaEmbeddable> ent = this.service.encuentraPorId(id);

        //¿Debería comprobar si hay datos?
        if (ent.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "GaleriaDto"
            //addAttribute y thymeleaf no  entienden Optional
            GaleriaEmbeddable attr = ent.get();
            GaleriaEmbeddableDto galeriaEmbeddableDto = new GaleriaEmbeddableDto();
            galeriaEmbeddableDto.setId(attr.getId());
            galeriaEmbeddableDto.setTitulo(attr.getTitulo());
            galeriaEmbeddableDto.setUrlImg(attr.getUrlImg());
            //Componentes de empleado
            galeriaEmbeddableDto.setEmpleadoId((int) attr.getEmpleadoGaleriaEmbed().getId());
            galeriaEmbeddableDto.setEmpleadoNombre(attr.getEmpleadoGaleriaEmbed().getNombre());
            //Añadimos las etiquetas
            Set<GaleriaEtiquetaEmbeddable>  galeriaEtiquetaEmbeddables =
                    galeriaEtiquetaEmbeddableService.getRepo().findAllByGaleriaEmbeddable_Id(Long.valueOf(id));
            Set<EtiquetaEmbeddable> etiquetaEmbeddables = new HashSet<>();
            for (GaleriaEtiquetaEmbeddable s : galeriaEtiquetaEmbeddables) {
                etiquetaEmbeddables.add(s.getEtiquetaEmbeddable());
            }
            galeriaEmbeddableDto.setEtiquetas(etiquetaEmbeddables);
            //Como recorrer la galeria y sus datos
            //Cuidado ¿Como gestionamos datos intermedios
            //Antes de ir a la pantalla necesito
            //Obtenemos el listado de empleado
            List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
            //obtengo la lista de etiquetas entidades!!!!!!
            List<EtiquetaEmbeddable>  etiquetasList = this.etiquetaService.buscarEntidades();


            //Asigno atributos y muestro
            interfazConPantalla.addAttribute("datos",galeriaEmbeddableDto);
            interfazConPantalla.addAttribute("listaEmpleados",empleadoDtoList);
            //Muestro la lista de todas las etiquetas
            interfazConPantalla.addAttribute("listaEtiquetas",etiquetasList);
            return "galeria/embed/edit";
        } else{
            //Mostrar página usuario no existe
            return "galeria/embed/detallesnoencontrado";
        }
    }
    //Me falta un postmaping para guardar
    @PostMapping("/galeria/embed/{id}")
    public String guardarEdicionDatosGaleria(@PathVariable("id") Integer id, GaleriaEmbeddableDto galeriaEmbeddableDto,
                                             Model model ) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaEmbeddable> galeriaEmbeddableControl = this.service.encuentraPorId(id);
        Set<GaleriaEtiquetaEmbeddable>  galeriaEtiquetaEmbeddables =
                galeriaEtiquetaEmbeddableService.getRepo().findAllByGaleriaEmbeddable_Id(Long.valueOf(id));

        //Obtenemos el listado de empleado
        List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
        //obtengo la lista de etiquetas entidades!!!!!!
        List<EtiquetaEmbeddable>  etiquetasList = this.etiquetaService.buscarEntidades();
        //¿Debería comprobar si hay datos?
        if (galeriaEmbeddableControl.isPresent()){
            //Cuidado ¿Como gestionamos datos intermedios
            //Fecha y hora actuales
            ZonedDateTime lt
                    = ZonedDateTime.now();
            //Cuidado ¿Como gestionamos datos intermedios
            //Tras añadir todos solo guardamos la galeria

            GaleriaEmbeddable galeriaEmbeddable = new GaleriaEmbeddable();
            galeriaEmbeddable.setId(galeriaEmbeddableDto.getId());
            galeriaEmbeddable.setTitulo(galeriaEmbeddableDto.getTitulo());
            galeriaEmbeddable.setUrlImg(galeriaEmbeddableDto.getUrlImg());
            Optional<Empleado> empleado = empleadoService.buscar(galeriaEmbeddableDto.getEmpleadoId());
            galeriaEmbeddable.setEmpleadoGaleriaEmbed(empleado.get());

            GaleriaEmbeddable galeriaEmbeddableG = service.guardar(galeriaEmbeddable);
            //Guardamos la entidad intermedia
            //Eliminamos relaciones anteriores

            System.out.println("Los datos a borrar son:" + galeriaEtiquetaEmbeddables.stream().count());
            for (GaleriaEtiquetaEmbeddable s : galeriaEtiquetaEmbeddables) {
                galeriaEtiquetaEmbeddableService.getRepo().deleteByEtiquetaEmbeddableIdAndGaleriaEmbeddableId(
                        s.getEtiquetaEmbeddable().getId(),galeriaEmbeddableDto.getId() );
            }

            // y creamnos relaciones nuevas
            for(EtiquetaEmbeddable  item:galeriaEmbeddableDto.getEtiquetas()){
                //Generamos la clave
                GaleriaEtiquetaKey galeriaEtiquetaKey = new GaleriaEtiquetaKey(galeriaEmbeddableG.getId(), item.getId());
                //Generamos la descripción
                String miDescripcion = "Doy de modifico la relacion con:" + item.getId();
                //Construimos la relacion
                GaleriaEtiquetaEmbeddable galeriaEtiquetaEmbeddable = new GaleriaEtiquetaEmbeddable(galeriaEtiquetaKey, item,galeriaEmbeddable,lt,miDescripcion);
                //Guardamos la ralacion
                galeriaEtiquetaEmbeddableService.guardar(galeriaEtiquetaEmbeddable);

            }
            //Regorremos en un bucle el set de etiquetas y gerenemos en galeria la relacion galeriaEtiquetaEmbeddable
            // Por cada relación informaremos los campos adicioneles
            // private ZonedDateTime fechaAlta; y    private String descripcion;
            //Asigno atributos y muestro
            model.addAttribute("datos",galeriaEmbeddableG);
            model.addAttribute("listaEmpleados",empleadoDtoList);
            //Muestro la lista de todas las etiquetas
            model.addAttribute("listaEtiquetas",etiquetasList);
            return String.format("redirect:/galeria/embed/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "galeria/embed/detallesnoencontrado";
        }
    }

    @PostMapping("/galeria/embed/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<GaleriaEmbeddable> galeriaEmbeddable = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (galeriaEmbeddable.isPresent()){
            this.service.eliminarPorId(id);
            //Tenemos que eliminar la relacióm??????
            //!!!!!!!!!!!!!!!!!!!!!!
            //Tenemos que buscar las etiquetas asociadas
            GaleriaEmbeddable galeriaEmbeddable1 = galeriaEmbeddable.get();
            //Recorremos la lista de etiquetas asociadas
            Set<GaleriaEtiquetaEmbeddable> galeriaEtiquetaEmbeddables = galeriaEmbeddable.get().getGaleriaEtiquetaEmbeddables();
            //Recorremos el set
            for(GaleriaEtiquetaEmbeddable  item:galeriaEtiquetaEmbeddables){
                galeriaEtiquetaEmbeddableService.getRepo().deleteByEtiquetaEmbeddableIdAndGaleriaEmbeddableId(
                        item.getGaleriaEmbeddable().getId(), galeriaEmbeddable1.getId());
            }
            //Mostrar listado de usuarios
            return "redirect:/galeria/embed";
        } else{
            //Mostrar página usuario no existe
            return "galeria/embed/detallesnoencontrado";
        }
    }

    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/galeria/embed/registro")
    public String vistaRegistroGaleria(Model interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final GaleriaEmbeddableDto galeriaEmbeddableDto = new GaleriaEmbeddableDto();
        //Cuidado ¿Como gestionamos datos intermedios
        //!!!!!!!!!!!!!!!!!!!!!!
        //Obtenemos el listado de empleados
        List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
        //obtengo la lista de etiquetas entidades!!!!!!
        List<EtiquetaEmbeddable>  etiquetasList = this.etiquetaService.buscarEntidades();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", galeriaEmbeddableDto);
        interfazConPantalla.addAttribute("listaEmpleados",empleadoDtoList);
        interfazConPantalla.addAttribute("listaEtiquetas",etiquetasList);
        return "galeria/embed/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/galeria/embed/registro")
    public String guardarEtiqueta(@ModelAttribute("datos") GaleriaEmbeddableDto galeriaEmbeddableDto) throws Exception {

        //Fecha y hora actuales
        ZonedDateTime lt
                = ZonedDateTime.now();
        //Cuidado ¿Como gestionamos datos intermedios
        //!!!!!!!!!!!!!!!!!!!!!!
        Optional<Empleado> empleado = empleadoService.buscar(galeriaEmbeddableDto.getEmpleadoId());
        if (empleado.isPresent()){
            Empleado empleadoalta = empleado.get();
            //Creamos la entidad galería con datos fijos ( aquellos campos solo de galeria)
            GaleriaEmbeddable galeriaEmbeddable = new GaleriaEmbeddable();
            galeriaEmbeddable.setTitulo(galeriaEmbeddableDto.getTitulo());
            galeriaEmbeddable.setUrlImg(galeriaEmbeddableDto.getUrlImg());
            galeriaEmbeddable.setEmpleadoGaleriaEmbed(empleadoalta);


            //Tras añadir todos solo guardamos la galeria
            GaleriaEmbeddable galeriaEmbeddableG =  service.guardar(galeriaEmbeddable);
            //Regorremos en un bucle el set de etiquetas y gerenemos en galeria la relacion galeriaEtiquetaEmbeddable
            // Por cada relación informaremos los campos adicioneles
            // private ZonedDateTime fechaAlta; y    private String descripcion;
            for(EtiquetaEmbeddable  item:galeriaEmbeddableDto.getEtiquetas()){
                //Generamos la clave
                GaleriaEtiquetaKey galeriaEtiquetaKey = new GaleriaEtiquetaKey(galeriaEmbeddableG.getId(), item.getId());
                //Generamos la descripción
                String miDescripcion = "Doy de alta la relacion con:" + item.getId();
                //Construimos la relacion
                GaleriaEtiquetaEmbeddable galeriaEtiquetaEmbeddable = new GaleriaEtiquetaEmbeddable(galeriaEtiquetaKey, item,galeriaEmbeddable,lt,miDescripcion);
                //Guardamos la ralacion
                galeriaEtiquetaEmbeddableService.guardar(galeriaEtiquetaEmbeddable);
            }

            //Gestionar la asignación de etiquetas
            Long id = galeriaEmbeddableG.getId();
            return String.format("redirect:/galeria/embed/%s", id);
        }
        else {
            return String.format("redirect:/galeria/registro");
        }

    }

}
