package com.jma.prolecto_sin_cambios_yml.service;


import com.jma.prolecto_sin_cambios_yml.model.Role;
import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import com.jma.prolecto_sin_cambios_yml.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioSecurityImpl implements IUsuarioServicio, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public String getEncodedPassword(Usuario usuario) {
        String passwd = usuario.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        return encodedPasswod;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername email : " + email);
        Usuario  usuario= usuarioRepository.findUsuarioByEmailAndActiveTrue(email);
        System.out.println("loadUserByUsername usuario : " + usuario.getNombreUsuario());

        org.springframework.security.core.userdetails.User springUser=null;

        Set<GrantedAuthority> ga = new HashSet<>();
        for (Role item : usuario.getRoles()){
            ga.add(new SimpleGrantedAuthority(item.getRoleName()));
        }
        springUser = new org.springframework.security.core.userdetails.User(
                email,
                usuario.getPassword(),
                ga );
        return springUser;
    }
}


