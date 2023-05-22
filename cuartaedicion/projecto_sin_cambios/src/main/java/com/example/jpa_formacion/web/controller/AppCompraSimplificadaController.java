package com.example.jpa_formacion.web.controller;



import com.example.jpa_formacion.model.*;
import com.example.jpa_formacion.service.*;
import com.example.jpa_formacion.util.LIstaProducto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
@SessionAttributes("productos")
@Controller
public class AppCompraSimplificadaController extends AbstractController<CompraSimplificada> {
    private final CompraSimplificadaService service;

    private final ProductoService productoService;

    public AppCompraSimplificadaController(MenuService menuService, CompraSimplificadaService service,
                                           ProductoService productoService) {
        super(menuService);
        this.service = service;
        this.productoService = productoService;
    }


    @GetMapping("/comprasimplificada")
    public String vista( ){
        return "carrito/mokupCarrito";
    }

    @GetMapping("/comprasimplificada/{id}")
    public String vistaDatosCompra(@PathVariable("id") Integer id, ModelMap interfazConPantalla){
        return "carrito/mokupCarrito";
    }
    //Me falta un postmaping para guardar
    @PostMapping("/comprasimplificada/{id}")
    public String guardarCompraDatosGaleria(@PathVariable("id") Integer id, CompraSimplificada compraSimplificada,
                                             Model model ) throws Exception {
        //Con el id tengo que buscar el registro a nivel de entidad
       return "carrito/mokupCarrito";
    }


    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/comprasimplificada/registro")
    public String vistaRegistroGaleria(Model interfazConPantalla)

    {
        //Instancia en memoria del dto a informar en la pantalla
        final CompraSimplificada compraSimplificada = new CompraSimplificada();
        //Cuidado ¿Como gestionamos datos intermedios
        //!!!!!!!!!!!!!!!!!!!!!!
        //Obtenemos el listado de empleados
        List<Producto> productos   = this.productoService.getAll();

        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datos", compraSimplificada);
        interfazConPantalla.addAttribute("listaproductos",productos);
        return "carrito/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/comprasimplificada/registro")
    public String guardarCompra(@ModelAttribute("datos") CompraSimplificada compraSimplificada,
                                @ModelAttribute("productos") LIstaProducto productosList,
                                RedirectAttributes attributes) throws Exception {

        //Fecha y hora actuales
        ZonedDateTime lt
                = ZonedDateTime.now();
        //Cuidado ¿Como gestionamos datos intermedios
        //Gestion de los productos para la sesion
        LIstaProducto lIstaProducto1 = new LIstaProducto();
        for(Producto  item:compraSimplificada.getProductos()){
            //añadir el producto a la sesion
            lIstaProducto1.addLIstaProducto(item);
        }
        System.out.println("Lista producto num:" + lIstaProducto1.count() );
        productosList = lIstaProducto1;
        attributes.addFlashAttribute("productos", productosList);

        //CompraSimplificada compraSimplificada1 = service.guardar(compraSimplificada);
        return "carrito/mokupCarrito";
    }
    @ModelAttribute("productos")
    public LIstaProducto lIstaProducto(){
        return new LIstaProducto();
    }

}
