package com.example.jpa_formacion.web.controller;

import com.example.jpa_formacion.dto.EtiquetaDtoApi;
import com.example.jpa_formacion.dto.LoginDto;
import com.example.jpa_formacion.dto.LoginToken;
import com.example.jpa_formacion.dto.UsuarioDto;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.service.UsuarioService;
import com.example.jpa_formacion.util.ResourceNotFoundException;
import com.example.jpa_formacion.util.UsuarioNoValidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/api/usuarios")
public class APIUsuariosController {
    private final UsuarioService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public APIUsuariosController(UsuarioService service) {
        this.service = service;
    }
    @GetMapping("")
    public  ResponseEntity<List<UsuarioDto>>  vistaUsuarios( ){
        //tenemos que leer la lista de usuarios
        //Que elemento me la ofrece?
        //listaUsrTodos
        List<UsuarioDto> lusrdto = this.service.buscarTodos();
        //Respuesta con el json
        //gestionar las respuestas
        if (lusrdto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //hay registros
        return new ResponseEntity<>(lusrdto, HttpStatus.OK);
    }

    @GetMapping("/login")
    public  ResponseEntity<LoginToken> loginAPI (@RequestBody LoginDto loginDto) throws ResourceNotFoundException {
        try{
            String usr = loginDto.getUsername();
            System.out.println("usr :" + usr);
            String password = loginDto.getPassword();
            System.out.println("pass :" + password);
            Usuario usuario = service.getRepo().findByEmailAndActiveTrue(usr);

            boolean matches = passwordEncoder.matches(password, usuario.getPassword());

            //¿es correcta la password?
            if (matches)
            {
                //Actualizar el token y devolverlo
                //Cambiamos el token
                String newtoken = this.cadenaAleatoria(50);
                usuario.setToken(newtoken);
                service.guardarEntidadEntidad(usuario);
                LoginToken  loginToken = new LoginToken();
                loginToken.setUsername(usuario.getEmail());
                loginToken.setToken(newtoken);
                return new ResponseEntity<>(loginToken,HttpStatus.OK);
            }else {
                throw new UsuarioNoValidoException("Login no valido para el usuario:" + usr);
            }
        } catch(UsuarioNoValidoException ex)
        {
            System.out.println("NO_CONTENT");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex) {
            System.out.println("BAD_REQUEST");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    public  String cadenaAleatoria(int longitud) {
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
