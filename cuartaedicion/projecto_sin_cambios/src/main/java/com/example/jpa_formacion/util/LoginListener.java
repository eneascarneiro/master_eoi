package com.example.jpa_formacion.util;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

    @Component
    public class LoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {
        @Override
        public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
        {
            String  username = "vacio";
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
            //Comprobamos si hay usuario logeado
            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
                System.out.println(this.getClass()+  ", Usario no logeado" + " " +"debug");
            }
            else {
                username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
                System.out.println(this.getClass()+   "El usuario es:" + username + " " + "debug");
            }
        }

    }
