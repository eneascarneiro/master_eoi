package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.dto.MenuDTO;
import com.app.gestionturnos.service.MenuService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//Esta clase abstracta admite cualuiertipode objeto DTO o entidad
public abstract class AbstractControllerMenu {

    MenuService menuService;

    protected AbstractControllerMenu(MenuService menuService) {
        this.menuService = menuService;
    }
    //Literal para los numeros de pagina

    @ModelAttribute("menuList")
    public List<MenuDTO> menu() {
        String  userName = "no informado";
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userName = "anonimo@anonimo";
        }
        else {
            userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        System.out.println("Menu 3 Usuario:" +userName  );
        return this.menuService.getMenuForEmail(userName);
    }

}
