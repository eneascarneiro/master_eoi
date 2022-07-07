package com.example.demo.web.controller;

import com.example.demo.data.entity.BooksRead;

import com.example.demo.data.entity.User;
import com.example.demo.data.jpql.BookReadJpqlImplDAO;
import com.example.demo.dto.InformeBooksReadSoldDTO;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
public class InformeController extends AbstractController<BooksRead>  {
    @Inject
    BookReadJpqlImplDAO bookReadJpqlImplDAO;
    @Autowired
    public InformeController(MenuService menuService) {
        super(menuService);
    }
    @GetMapping("/informes")
    public String getAll(Model model) {

        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final List<InformeBooksReadSoldDTO> all =  bookReadJpqlImplDAO.getSummaryReadSold();
                model
                .addAttribute("username", user.getUserName())
                .addAttribute("listado", all);
        return "informes/list6";
    }


}
