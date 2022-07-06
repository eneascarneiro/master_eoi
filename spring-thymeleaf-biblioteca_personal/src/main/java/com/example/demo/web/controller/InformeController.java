package com.example.demo.web.controller;

import com.example.demo.data.entity.BooksSold;
import com.example.demo.data.entity.User;
import com.example.demo.dto.Informe4Campos;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class InformeController extends AbstractController<Informe4Campos>  {
    @PersistenceContext
    EntityManager entityManager;

    private static final String QUERY = "SELECT bs " +
            "FROM BooksSold bs " +
            "join bs.user usr " +
            "where usr.id = 3";

    public List<BooksSold> queryInformeLibrosAdmin(){
        return (List<BooksSold>)  entityManager.createQuery(QUERY).getResultList();
    }
    @Autowired
    protected InformeController(MenuService menuService) {
        super(menuService);
    }
    @GetMapping("/informes")
    public String getAll(Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final List<BooksSold> all = queryInformeLibrosAdmin();
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("listado", all);
        return "informes/list4";
    }

}
