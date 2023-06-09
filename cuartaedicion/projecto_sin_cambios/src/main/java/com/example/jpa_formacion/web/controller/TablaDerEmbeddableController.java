package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.TablaDerEmbeddableDto;
import com.example.jpa_formacion.model.*;
import com.example.jpa_formacion.service.MenuService;
import com.example.jpa_formacion.service.TablaDerEmbeddableService;
import com.example.jpa_formacion.service.TablaIzqEmbeddableService;
import com.example.jpa_formacion.service.TablaIzqTablaDerEmbeddableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class TablaDerEmbeddableController extends AbstractController<TablaDerEmbeddable> {

    private final TablaDerEmbeddableService service;

    private final TablaIzqEmbeddableService izqservice;

    private final TablaIzqTablaDerEmbeddableService tablaIzqTablaDerEmbeddableService;

    public TablaDerEmbeddableController(MenuService menuService, TablaDerEmbeddableService service, TablaIzqEmbeddableService izqservice, TablaIzqTablaDerEmbeddableService tablaIzqTablaDerEmbeddableService) {
        super(menuService);
        this.service = service;
        this.izqservice = izqservice;
        this.tablaIzqTablaDerEmbeddableService = tablaIzqTablaDerEmbeddableService;
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
    @GetMapping("/mnembedder/list")
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
        Page<TablaDerEmbeddable> entsLPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));

        System.out.println("numero de registros:" + entsLPage.stream().count());
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(entsLPage));
        interfazConPantalla.addAttribute("listaDtos", entsLPage);
        return "mnembedder/listapagina";
    }
    @GetMapping("/mnembedder/mokup")
    public String mookupdatos(ModelMap interfazConPantalla){

        List<TablaDerEmbeddable> entsList = this.service.buscarEntidades();
        interfazConPantalla.addAttribute("listaDtos", entsList);
        return "mnembedder/mokup";
    }

    @GetMapping("/mnembedder/{id}")
    public String vistaDatosDer(@PathVariable("id") Long id,
                                    ModelMap interfazConPantalla){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<TablaDerEmbeddable> ent_opt = service.encuentraPorId(id);
        //Componer el dto TablaDerEmbeddableDto
        if (ent_opt.isPresent()){
            TablaDerEmbeddableDto dto = new TablaDerEmbeddableDto();
            dto.setId(id);
            dto.setDescripcion(ent_opt.get().getDescripcion());
            for(TablaIzqTablaDerEmbeddable item: ent_opt.get().getTablaIzqTablaDerEmbeddables()) {
                dto.getTblizq().add(item.getReltablaizqEmbeddable());
            }
            TablaIzqEmbeddable primerelemnto = dto.getTblizq().iterator().next();
            Set<String> listadirectorio = listFilesUsingJavaIO("src/main/resources/static/imagenesempl");

            String primeraimagen = listadirectorio.iterator().next().toString();
            System.out.println("primeraimagen:" + primeraimagen );

            List<TablaIzqEmbeddable> tablaIzqEmbeddables = this.izqservice.buscarEntidades();
            interfazConPantalla.addAttribute("datos",dto);
            interfazConPantalla.addAttribute("listaimg",listadirectorio);
            interfazConPantalla.addAttribute("primeraimg",primeraimagen);
            interfazConPantalla.addAttribute("primerelmIzq",primerelemnto);
            interfazConPantalla.addAttribute("listaizq",tablaIzqEmbeddables);
            return "mnembedder/edit";
        } else{
            return "mnembedder/detallesnoencontrado";
        }

    }
    @PostMapping("/mnembedder/{id}")
    public String guardarEdicionDatosEnt(@PathVariable("id") Long id,@ModelAttribute("datos")TablaDerEmbeddableDto dto) throws Exception {
        //comprobamos que existe el registro
        Optional<TablaDerEmbeddable> ent_opt = service.encuentraPorId(id);
        Set<TablaIzqTablaDerEmbeddable> tablaIzqTablaDerEmbeddables =
                tablaIzqTablaDerEmbeddableService.getRepo().findAllByReltabladerEmbeddableId(id);
        if (ent_opt.isPresent()){
            //Nos llega un dto , tenemos que traducirlo a la entidad
            TablaDerEmbeddable ent = ent_opt.get();
            ent.setDescripcion(dto.getDescripcion());
            //Eliminamos relaciones anteriores
            /*for(TablaIzqTablaDerEmbeddable item_m: tablaIzqTablaDerEmbeddables) {
                tablaIzqTablaDerEmbeddableService.getRepo().deleteByReltabladerEmbeddableIdAndReltablaizqEmbeddableId(
                                id,item_m.getReltablaizqEmbeddable().getId() );
            }*/
            //Damos de alta todo de nuevo
            for(TablaIzqEmbeddable item: dto.getTblizq()) {
                //creamos el objeto/os intemedios
                //key
                TablaIzqTablaDerKey tablaIzqTablaDerKey =
                        new TablaIzqTablaDerKey(ent.getId(),item.getId());
                //Instancio la clase
                TablaIzqTablaDerEmbeddable tablaIzqTablaDerEmbeddable = new TablaIzqTablaDerEmbeddable();
                tablaIzqTablaDerEmbeddable.setId(tablaIzqTablaDerKey);
                //Elemento para tabla derecha
                tablaIzqTablaDerEmbeddable.setReltabladerEmbeddable(ent);
                //Elemento para tabla izquierda
                tablaIzqTablaDerEmbeddable.setReltablaizqEmbeddable(item);
                this.tablaIzqTablaDerEmbeddableService.guardar(tablaIzqTablaDerEmbeddable);
            }
            return String.format("redirect:/mnembedder/%s", id);
        } else{
            return "mnembedder/detallesnoencontrado";
        }
    }

    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/mnembedder/registro")
    public String vistaRegistro(ModelMap interfazConPantalla)
    {
        //Instancia en memoria del dto a informar en la pantalla
        final TablaDerEmbeddableDto dto = new TablaDerEmbeddableDto();
        List<TablaIzqEmbeddable> tablaIzqEmbeddables = this.izqservice.buscarEntidades();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("listaizq",tablaIzqEmbeddables);
        interfazConPantalla.addAttribute("datos", dto);
        return "mnembedder/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/mnembedder/registro")
    public String guardarEtiqueta(@ModelAttribute("datos")TablaDerEmbeddableDto dto) throws Exception {
        //Nos llega un dto , tenemos que traducirlo a la entidad
        TablaDerEmbeddable ent = new TablaDerEmbeddable();
        ent.setDescripcion(dto.getDescripcion());
        //¿Como generamos la tabla intermedia?
        //Cuidado ¿Como gestionamos datos intermedios?
        //!!!!!!!!!!!!!!!!!!!!!!
        //Guardamos primero el registro de la entidad derecha
        TablaDerEmbeddable entGuardada = this.service.guardar(ent);
        for(TablaIzqEmbeddable item: dto.getTblizq()) {
            //creamos el objeto/os intemedios
            //key
            TablaIzqTablaDerKey tablaIzqTablaDerKey =
                    new TablaIzqTablaDerKey(entGuardada.getId(),item.getId());
            //Instancio la clase
            TablaIzqTablaDerEmbeddable tablaIzqTablaDerEmbeddable = new TablaIzqTablaDerEmbeddable();
            tablaIzqTablaDerEmbeddable.setId(tablaIzqTablaDerKey);
            //Elemento para tabla derecha
            tablaIzqTablaDerEmbeddable.setReltabladerEmbeddable(entGuardada);
            //Elemento para tabla izquierda
            tablaIzqTablaDerEmbeddable.setReltablaizqEmbeddable(item);
            this.tablaIzqTablaDerEmbeddableService.guardar(tablaIzqTablaDerEmbeddable);
        }
        Long id = entGuardada.getId();
        return String.format("redirect:/mnembedder/%s", id);
    }


    @PostMapping("/mnembedder/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Long id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<TablaDerEmbeddable> ent = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (ent.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/mnembedder";
        } else{
            //Mostrar página usuario no existe
            return "mnembedder/detallesnoencontrado";
        }
    }

}
