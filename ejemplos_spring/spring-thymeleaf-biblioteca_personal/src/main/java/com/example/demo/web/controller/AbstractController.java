package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.MenuDTO;
import com.example.demo.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractController<DTO> {

    private final MenuService menuService;
    protected final String pageNumbersAttributeKey = "pageNumbers";

    protected AbstractController(MenuService menuService) {
        this.menuService = menuService;
    }

    @ModelAttribute("menuList")
    public List<MenuDTO> menu() {
         Integer userId = -1;
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        //Comprobamos si hay usuario logeado
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            userId = 99999;
        }
        else {
            userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        }
        return this.menuService.getMenuForUserId(userId);
    }

    protected List<Integer> getPageNumbers(Page<DTO> pages) {
        return pages.getTotalPages() > 0 ?
                IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList()) :
                new ArrayList<>();
    }
}
