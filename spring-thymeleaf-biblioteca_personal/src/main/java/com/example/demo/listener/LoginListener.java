package com.example.demo.listener;


import com.example.demo.data.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
    {
        Integer userId = -1;
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            System.out.println("Usario no logeado");
        }
        else {
            userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            System.out.println("El usuario es:" + userId );
        }

    }
}