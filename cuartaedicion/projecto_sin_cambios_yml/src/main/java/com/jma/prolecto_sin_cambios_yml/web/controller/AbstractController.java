package com.jma.prolecto_sin_cambios_yml.web.controller;

import com.jma.prolecto_sin_cambios_yml.service.MenuService;
import org.springframework.data.domain.Page;

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
    /*@ModelAttribute("menuList")
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
        return this.menuService.getMenuForEmail(userName);
    }
*/
}
