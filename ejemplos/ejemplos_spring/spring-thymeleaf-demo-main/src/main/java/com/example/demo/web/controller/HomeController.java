package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController extends AbstractController {

    @Autowired
    public HomeController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping("/")
    public String homePage(ModelMap model) {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", ((User) principal).getUserName());
        return "home";
    }
}
