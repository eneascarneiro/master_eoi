package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.dto.MenuDTO;
import com.app.gestionturnos.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//Esta clase abstracta admite cualuiertipode objeto DTO o entidad
public abstract class   AbstractController<OBJ> {

    MenuService menuService;

    protected AbstractController(MenuService menuService) {
        this.menuService = menuService;
    }
    //Literal para los numeros de pagina
    protected final String pageNumbersAttributeKey = "pageNumbers";
    //Metodo para obtener los numeros de pagina
    protected List<Integer> dameNumPaginas(Page<OBJ>  obj){
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPages = obj.getTotalPages();
        if (totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return pageNumbers;
    }
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
        System.out.println("Menu 2 Usuario:" +userName  );
        return this.menuService.getMenuForEmail(userName);
    }

}
