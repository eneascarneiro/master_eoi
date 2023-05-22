package com.example.jpa_formacion.web.controller;


import com.example.jpa_formacion.dto.ClienteDto;
import com.example.jpa_formacion.dto.EmpleadoDto;
import com.example.jpa_formacion.model.Cliente;
import com.example.jpa_formacion.service.ClienteService;
import com.example.jpa_formacion.service.EmpleadoService;
import com.example.jpa_formacion.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AppClienteController  extends AbstractController<ClienteDto> {
    private final ClienteService service;
    private EmpleadoService empleadoService;


    public AppClienteController(MenuService menuService, ClienteService service, EmpleadoService empleadoService) {
        super(menuService);
        this.service = service;
        this.empleadoService = empleadoService;
    }


    @GetMapping("/clientes")
    public String vistaClientes(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                ModelMap interfazConPantalla){

        Integer pagina = 0;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }

        Page<ClienteDto > dtoPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(dtoPage));
        interfazConPantalla.addAttribute("lista", dtoPage);
        return "clientes/listaclientespagina";
    }
    @GetMapping("/clientes/{id}")
    public String vistaDatos(@PathVariable("id") Integer id, ModelMap interfazConPantalla){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<ClienteDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "UsuarioDto"
            //addAttribute y thymeleaf no  entienden Optional
            ClienteDto attr = dto.get();
            //Obtenemos el listado de empleados para la edicion
            List<EmpleadoDto> empleadoDtoList   = this.empleadoService.buscarTodos();
            //Enviamos la lista a la pantalla
            interfazConPantalla.addAttribute("listaempleados",empleadoDtoList);
            //Asigno atributos y muestro
            interfazConPantalla.addAttribute("datos",attr);
            return "clientes/edit";
        } else{
            //Mostrar página usuario no existe
            return "clientes/detallesnoencontrado";
        }
    }
    //Me falta un postmaping para guardar
    @PostMapping("/clientes/{id}")
    public String guardarEdicionDatos(@PathVariable("id") Integer id, ClienteDto dtoEntrada) throws Exception {
        //Cuidado que la password no viene
        //Necesitamos copiar la información que llega menos la password
        //Con el id tengo que buscar el registro a nivel de entidad
        System.out.println("Cliente guardarEdicionDatos dto emplid:"+ dtoEntrada.getEmpleadoId() );
        Optional<ClienteDto> dtoControl = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dtoControl.isPresent()){
            this.service.guardar(dtoEntrada);
            return String.format("redirect:/clientes/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "clientes/detallesnoencontrado";
        }
    }
    /*
    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/registro")
    public String vistaRegistro(ModelMap interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final UsuarioDto usuarioDto = new UsuarioDto();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosUsuario",usuarioDto);
        return "usuarios/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/registro")
    public String guardarUsuario(UsuarioDto usuarioDto) throws Exception {
        //LLamo al método del servicioi para guardar los datos
        UsuarioDto usuarioGuardado =  this.service.guardar(usuarioDto);
        Long id = usuarioGuardado.getId();
        //return "usuarios/detallesusuario";
        return String.format("redirect:/usuarios/%s", id);
    }
*/
    @PostMapping("/clientes/{id}/delete")
    public String eliminarDatos(@PathVariable("id") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<ClienteDto> dto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (dto.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/clientes";
        } else{
            //Mostrar página usuario no existe
            return "clientes/detallesnoencontrado";
        }
    }

    /*
    // Lista múltiple de edición
    @GetMapping("/usuarios/editmultiple")
    public String mostrarEditMultipleForm(Model intefrazConPantalla) {
        UsuariosListaDto usuariosListaDto = new UsuariosListaDto(this.service.buscarTodos());

        intefrazConPantalla.addAttribute("form", usuariosListaDto);
        return "usuarios/listaeditableusuarios";
    }
    @PostMapping("/usuarios/savemultiple")
    public String saveListaUsuariuos(@ModelAttribute UsuariosListaDto usuariosListaDto) {
        service.guardar(usuariosListaDto.getUsuarioDtos());
        return "redirect:/usuarios";
    }
    */

}
