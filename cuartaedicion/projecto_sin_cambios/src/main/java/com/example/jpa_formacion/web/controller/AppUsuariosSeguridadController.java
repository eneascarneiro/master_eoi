package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.*;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.service.IUsuarioServicio;
import com.example.jpa_formacion.service.RoleService;
import com.example.jpa_formacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.jpa_formacion.util.ValidarFormatoPassword.ValidarFormato;

@Controller
public class AppUsuariosSeguridadController  {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioServicio userService;
    private final  UsuarioService service;
    private final RoleService roleService;

    public AppUsuariosSeguridadController(UsuarioService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }


    // Read Form data to save into DB

    //Para crear un usuario hay dos bloques
    //El que genera la pantalla para pedir los datos de tipo GetMapping
    //Cuando pasamos informacion a la pantalla hay que usar ModelMap
    @GetMapping("/usuarios/registro")
    public String vistaRegistro(Model interfazConPantalla){
        //Instancia en memoria del dto a informar en la pantalla
        final UsuarioDtoPsw usuarioDtoPsw = new UsuarioDtoPsw();
        //Obtengo la lista de roles
        final List<RoleDTO> roleDTOList = roleService.buscarTodos();
        //Mediante "addAttribute" comparto con la pantalla
        interfazConPantalla.addAttribute("datosUsuario",usuarioDtoPsw);
        interfazConPantalla.addAttribute("listaRoles",roleDTOList);
        System.out.println("Preparando pantalla registro");
        return "usuarios/registro";
    }
    //El que con los datos de la pantalla guarda la informacion de tipo PostMapping
    @PostMapping("/usuarios/registro")
    public String guardarUsuario( @ModelAttribute(name ="datosUsuario") UsuarioDtoPsw usuarioDtoPsw) throws Exception {
        //Comprobamos el patron
        System.out.println("Guardando usuario antes ");
        System.out.println("Usuario :" + usuarioDtoPsw.getNombreUsuario() + ", password : " + usuarioDtoPsw.getPassword() );
        if (ValidarFormato(usuarioDtoPsw.getPassword())){
            Usuario usuario = service.getMapper().toEntityPsw(usuarioDtoPsw);
            System.out.println("Guardando usuario");
            System.out.println("Usuario :" + usuario.getNombreUsuario() + ", password : " + usuario.getPassword() );
            //Codifico la password
            String encodedPasswod = userService.getEncodedPassword(usuario);
            usuarioDtoPsw.setPassword(encodedPasswod);
            //El usuario se guarda como no autorizado
            //Guardo la password
            UsuarioDto usuario1 = this.service.guardar(usuarioDtoPsw);
            //return "usuarios/detallesusuario";
            return String.format("redirect:/usuarios/%s", usuario1.getId());
        }
        else
        {
            return "usuarios/registro";
        }

    }
    //Controlador de cambio de password
    @GetMapping("/usuarios/cambiopass")
    public String vistaCambiopasword(){
        return "usuarios/cambiopasword";
    }
    @PostMapping("/usuarios/cambiopass")
    public String cambioPasswordPst(@ModelAttribute(name = "loginForm" ) CambioPswDto cambioPswDto) throws Exception {
        //Encrptamos las passwords
        String passwordAnt =  passwordEncoder.encode(cambioPswDto.getPasswordant());
        String passwordNueva =  passwordEncoder.encode(cambioPswDto.getPasswordnueva());
        //Comprobamos que existe el usuario por email y passweord
        if (service.getRepo().repValidarPassword(cambioPswDto.getUsername(), passwordAnt) > 0)
        {
            //Modificicamos la passsword
            Usuario usuario = service.getRepo().findUsuarioByEmailAndPassword(cambioPswDto.getUsername(),
                    passwordAnt );
            usuario.setPassword(passwordNueva);
            //Guardamos el usuario
            Usuario usuario1 = service.guardarEntidadEntidad(usuario);
            return "usuarios/login";
        }else {
            return "usuarios/cambiopasword";
        }
    }
}
