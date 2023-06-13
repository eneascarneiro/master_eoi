package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.dto.UsuarioDto;
import com.app.gestionturnos.model.Empresa;
import com.app.gestionturnos.model.TipoEmpresa;
import com.app.gestionturnos.repository.EmpresaRepository;
import com.app.gestionturnos.service.EmpresaService;
import com.app.gestionturnos.service.MenuService;
import com.app.gestionturnos.service.TipoEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class APPEmpresaController  extends AbstractController<Empresa> {

    private final EmpresaService service;
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    TipoEmpresaService tipoEmpresaService;


    protected APPEmpresaController(MenuService menuService, EmpresaService service) {
        super(menuService);
        this.service = service;
    }

    @GetMapping("/empresas/listaempresas")
    public String getAllEmpresas(ModelMap interfazConPantalla) {
        //generamos el contenedor
        List<Empresa> empresas = service.buscarEntidades();
        System.out.println(empresas.size());

        interfazConPantalla.addAttribute("lista", empresas);
        return "empresas/all";
    }

    @GetMapping("/empresas/listaempresasp")
    public String getAllEmpresasPag(@RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size,
                                    ModelMap interfazConPantalla) {
        Integer pagina = 1;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        //generamos el contenedor
        //List<Empresa> empresas = service.buscarEntidades();

        Page<Empresa> empresaPageable = service.buscarTodos(PageRequest.of(pagina,maxelementos));
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(empresaPageable));
        interfazConPantalla.addAttribute("lista", empresaPageable);
        return "empresas/allpag";
    }
    @GetMapping("/empresas/listaempresasporbusq")
    public String getAllEmpresasPagOrdBusq(@RequestParam("page") Optional<Integer> page,
                                            @RequestParam("size") Optional<Integer> size,
                                            @RequestParam(required = false) String keywordciudad,
                                            @RequestParam(required = false) String keywordpais,
                                            @RequestParam(required = false) String keywordregion,
                                            @RequestParam(required = false) String keywordcodigopostal,
                                            @RequestParam(required = false) String keywordtelefono,
                                            @RequestParam(required = false) String keyworddireccion1,
                                            @RequestParam(required = false) String keyworddireccion2,
                                            @RequestParam(defaultValue = "id,asc") String[] sort,
                                            ModelMap interfazConPantalla) {
        //Gestion de los datos de ordenación
        String sortField = sort[0];
        String sortDirection = sort[1];

        Sort.Direction direction = sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort.Order order = new Sort.Order(direction, sortField);
        //Gestion de los datos de paginas
        Integer pagina = 1;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        //generamos el contenedor
        //Objetos genericos de ordenamiento y paginacion
        Pageable pageable = PageRequest.of(pagina, maxelementos, Sort.by(order));
        Page<Empresa> empresaPageable = null;
        //El objeto empresaPageable cambiara de contenido en función de los filtros y/o del orden
        if (keywordciudad == null &&  keywordpais == null &&  keywordregion == null &&  keywordcodigopostal == null
                && keywordtelefono == null &&  keyworddireccion1 == null &&  keyworddireccion2 == null) {
            empresaPageable = this.service.buscarTodos(pageable);
        } else if (keywordciudad != null && keywordciudad.length() > 0  ){
            keywordpais = null;
            keywordregion = null;
            keywordcodigopostal = null;
            keywordtelefono = null;
            keyworddireccion1 = null;
            keyworddireccion2 = null;
            //Neciso un método que ordene por ciudad
            empresaPageable = service.getRepo().findEmpresaByCiudadContainingIgnoreCase(keywordciudad,pageable);
            interfazConPantalla.addAttribute("keywordciudad",keywordciudad);
        } else if (keywordpais != null && keywordpais.length() > 0 ){
            keywordciudad = null;
            keywordregion = null;
            keywordcodigopostal = null;
            keywordtelefono = null;
            keyworddireccion1 = null;
            keyworddireccion2 = null;
            empresaPageable = service.getRepo().findEmpresaByPaisContainingIgnoreCase(keywordpais,pageable);
            interfazConPantalla.addAttribute("keywordpais",keywordpais);
        }else if (keywordregion != null &&  keywordregion.length() > 0 ){
            keywordciudad = null;
            keywordpais = null;
            keywordcodigopostal = null;
            keywordtelefono = null;
            keyworddireccion1 = null;
            keyworddireccion2 = null;
            empresaPageable = service.getRepo().findEmpresaByRegionContainingIgnoreCase(keywordregion,pageable);
            interfazConPantalla.addAttribute("keywordregion",keywordregion);
        }else if (keywordcodigopostal != null  && keywordcodigopostal.length() > 0 ){
            keywordciudad = null;
            keywordpais = null;
            keywordregion = null;
            keywordtelefono = null;
            keyworddireccion1 = null;
            keyworddireccion2 = null;
            empresaPageable = service.getRepo().findEmpresaByCodigopostalContainingIgnoreCase(keywordcodigopostal,pageable);
            interfazConPantalla.addAttribute("keywordcodigopostal",keywordcodigopostal);
        }else if (keywordtelefono != null  && keywordtelefono.length() > 0 ){
            keywordciudad = null;
            keywordpais = null;
            keywordregion = null;
            keywordcodigopostal = null;
            keyworddireccion1 = null;
            keyworddireccion2 = null;
            empresaPageable = service.getRepo().findEmpresaByTelefonoContainingIgnoreCase(keywordtelefono,pageable);
            interfazConPantalla.addAttribute("keywordtelefono",keywordtelefono);
        }else if (keyworddireccion1 != null && keyworddireccion1.length() > 0  ){
            keywordciudad = null;
            keywordpais = null;
            keywordregion = null;
            keywordcodigopostal = null;
            keywordtelefono = null;
            keyworddireccion2 = null;
            empresaPageable = service.getRepo().findEmpresaByLineadireccion1ContainingIgnoreCase(keyworddireccion1,pageable);
            interfazConPantalla.addAttribute("keyworddireccion1",keyworddireccion1);
        }else if (keyworddireccion2 != null   && keyworddireccion2.length() > 0  ){
            keywordciudad = null;
            keywordpais = null;
            keywordregion = null;
            keywordcodigopostal = null;
            keywordtelefono = null;
            keyworddireccion1 = null;
            empresaPageable = service.getRepo().findEmpresaByLineadireccion2ContainingIgnoreCase(keyworddireccion2,pageable);
            interfazConPantalla.addAttribute("keyworddireccion2",keyworddireccion2);
        }

        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(empresaPageable));
        interfazConPantalla.addAttribute("currentPage", empresaPageable.getNumber() );
        interfazConPantalla.addAttribute("pageSize", maxelementos);
        interfazConPantalla.addAttribute("lista", empresaPageable);
        interfazConPantalla.addAttribute("sortField", sortField);
        interfazConPantalla.addAttribute("sortDirection", sortDirection);
        interfazConPantalla.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        return "empresas/allpagordbusq";
    }


    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/empresas/registro")
    public String vistaRegistro(Model interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final Empresa empresa = new Empresa();
        //Obtengo la lista de roles
        final List<TipoEmpresa> tipoEmpresasList = tipoEmpresaService.buscarEntidades();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos",empresa);
        interfazConPantalla.addAttribute("listatipos",tipoEmpresasList);
        System.out.println("Preparando pantalla registro");
        return "empresas/new";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/empresas/registro")
    public String guardarEmpresa( @ModelAttribute(name ="datos") Empresa empresa) throws Exception {
        this.empresaRepository.save(empresa);
        return "empresas/all";
    }

}
