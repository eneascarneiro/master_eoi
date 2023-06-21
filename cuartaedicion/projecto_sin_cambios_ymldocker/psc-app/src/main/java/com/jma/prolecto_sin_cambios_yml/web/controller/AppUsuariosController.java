package com.jma.prolecto_sin_cambios_yml.web.controller;

import com.jma.prolecto_sin_cambios_yml.dto.*;
import com.jma.prolecto_sin_cambios_yml.dto.LoginDto;
import com.jma.prolecto_sin_cambios_yml.dto.UsuarioCambioPsw;
import com.jma.prolecto_sin_cambios_yml.dto.UsuarioDto;
import com.jma.prolecto_sin_cambios_yml.dto.UsuariosListaDto;
import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import com.jma.prolecto_sin_cambios_yml.service.MenuService;
import com.jma.prolecto_sin_cambios_yml.service.RoleService;
import com.jma.prolecto_sin_cambios_yml.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



import java.util.*;

@Controller
public class AppUsuariosController extends AbstractController <UsuarioDto> {

    private final UsuarioService service;
    private final RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AppUsuariosController(MenuService menuService, UsuarioService service, RoleService roleService) {
        super(menuService);
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String vistaHome(){
        Usuario usuario = new Usuario();
        //String miprimerareparacion = usuario.getEmpleado().getReparaciones().iterator().next().getId();
        //String oficina = usuario.getEmpleado().getOficina().getCiudad();
        Long miprimervehiculoreparado = usuario.getEmpleado().getReparaciones().iterator().next().getId();

        String miprimervehiculo = usuario.getEmpleado().getClientes().iterator().next().getVehiculos().get(1).getMatricula();
        Long miprimervehiculoreparadotambien = usuario.getEmpleado().getClientes().iterator().next().getVehiculos().get(1).getId();


        return "index";
    }
    @GetMapping("/usuarios")
    public String vistaUsuarios(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                    ModelMap interfazConPantalla){


        //tenemos que leer la lista de usuarios
        //Que elemento me la ofrece?
        //listaUsrTodos
        //List<UsuarioDto>  lusrdto = this.service.listaUsrTodos();
        //interfazConPantalla.addAttribute("listausuarios", lusrdto);
        //Obetenemos el objeto Page del servicio
        Integer pagina = 1;
        if (page.isPresent()) {
            pagina = page.get() -1;
        }
        Integer maxelementos = 10;
        if (size.isPresent()) {
            maxelementos = size.get();
        }
        Page<UsuarioDto> usuarioDtoPage =
                this.service.buscarTodos(PageRequest.of(pagina,maxelementos));
        interfazConPantalla.addAttribute(pageNumbersAttributeKey,dameNumPaginas(usuarioDtoPage));
        interfazConPantalla.addAttribute("listausuarios", usuarioDtoPage);
        return "usuarios/listausuariospagina";
    }

    @GetMapping("/usuarios/{idusr}")
    @PostAuthorize("hasRole('ADMIN')")
    public String vistaDatosUsuario(@PathVariable("idusr") Integer id, ModelMap interfazConPantalla){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<UsuarioDto> usuarioDto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (usuarioDto.isPresent()){
            //Como encontré datos, obtengo el objerto de tipo "UsuarioDto"
            //addAttribute y thymeleaf no  entienden Optional
            UsuarioDto attr = usuarioDto.get();
            //Asigno atributos y muestro
            interfazConPantalla.addAttribute("datosUsuario",attr);

            return "usuarios/edit";
        } else{
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }


    @PostMapping("/usuarios/{idusr}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminarDatosUsuario(@PathVariable("idusr") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<UsuarioDto> usuarioDto = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (usuarioDto.isPresent()){
            this.service.eliminarPorId(id);
            //Mostrar listado de usuarios
            return "redirect:/usuarios";
        } else{
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }
    @PostMapping("/usuarios/{idusr}/habilitar")
    @PreAuthorize("hasRole('ADMIN')")
    public String habilitarDatosUsuario(@PathVariable("idusr") Integer id){
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<Usuario> usuario = this.service.encuentraPorIdEntity(id);
        //¿Debería comprobar si hay datos?
        if (usuario.isPresent()){
            Usuario attr = usuario.get();
            if (attr.isActive())
                attr.setActive(false);
            else
                attr.setActive(true);
            this.service.getRepo().save(attr);
            //Mostrar listado de usuarios
            return "redirect:/usuarios";
        } else{
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }


    //Me falta un postmaping para guardar
    @PostMapping("/usuarios/{idusr}")
    public String guardarEdicionDatosUsuario(@PathVariable("idusr") Integer id, UsuarioDto usuarioDtoEntrada) throws Exception {
        //Cuidado que la password no viene
        //Necesitamos copiar la información que llega menos la password
        //Con el id tengo que buscar el registro a nivel de entidad
        Optional<UsuarioDto> usuarioDtoControl = this.service.encuentraPorId(id);
        //¿Debería comprobar si hay datos?
        if (usuarioDtoControl.isPresent()){
            //LLamo al método del servicioi para guardar los datos
            UsuarioDto usuarioDtoGuardar =  new UsuarioDto();
            usuarioDtoGuardar.setId(id);
            usuarioDtoGuardar.setEmail(usuarioDtoEntrada.getEmail());
            usuarioDtoGuardar.setNombreUsuario(usuarioDtoEntrada.getNombreUsuario());
            //Obtenemos la password del sercio
            Optional<Usuario> usuario = service.encuentraPorIdEntity((int) usuarioDtoGuardar.getId());
            if(usuario.isPresent()){
                this.service.guardar(usuarioDtoGuardar,usuario.get().getPassword());
            }
            else {
                this.service.guardar(usuarioDtoGuardar);
            }
            return String.format("redirect:/usuarios/%s", id);
        } else {
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }
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
    //Controlador de Login
    @GetMapping("/usuarios/login")
    public String vistaLogin(){
        return "usuarios/login";
    }
    @PostMapping("/usuarios/login")
    public String validarPasswordPst(@ModelAttribute(name = "loginForm" ) LoginDto loginDto) {
        String usr = loginDto.getUsername();
        System.out.println("usr :" + usr);
        String password = loginDto.getPassword();
        System.out.println("pass :" + password);
        //¿es correcta la password?
        if (service.getRepo().repValidarPassword(usr, passwordEncoder.encode(password) ) > 0)
        {
            return "index";
        }else {
            return "usuarios/login";
        }
    }


    @GetMapping("/login-error")
    public String login(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(  WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage() ;
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "usuarios/login";
    }
    // Reset password
    @GetMapping("/usuarios/resetpass/{usrname}/{token}")
    public String cambiopass(@PathVariable("usrname") String username, @PathVariable("token") String token, ModelMap intefrazConPantalla) {
        Optional<Usuario> usuario = service.getRepo().findByEmailAndTokenAndActiveTrue(username,token );
        System.out.println(username + ":" + token );
        UsuarioCambioPsw usuarioCambioPsw = new UsuarioCambioPsw();

        if (usuario.isPresent()){
            usuarioCambioPsw.setUsuario(usuario.get().getEmail());
            usuarioCambioPsw.setPassword("******************");
            usuarioCambioPsw.setNewpassword("******************");
            intefrazConPantalla.addAttribute("datos", usuarioCambioPsw);
            return "usuarios/resetearpasswordlogin";
        }else {
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }
    }
    @PostMapping("/usuarios/resetpass")
    public String saveListaUsuariuos(@ModelAttribute  UsuarioCambioPsw  dto) throws Exception {
        //Si las password no coinciden a la pag de error
        if (dto.getPassword().equals(dto.getNewpassword())){
            //Buscamnos el usuario
            Usuario usuario = service.getRepo().findByEmailAndActiveTrue(dto.getUsuario());
            //Actualizo la password despues de codificarla
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
            //Guardo el usuario
            Usuario usuarioguarado = service.guardarEntidadEntidad(usuario);
            return "redirect:/usuarios/login";
        }else {
            //Mostrar página usuario no existe
            return "usuarios/detallesusuarionoencontrado";
        }

    }

}
