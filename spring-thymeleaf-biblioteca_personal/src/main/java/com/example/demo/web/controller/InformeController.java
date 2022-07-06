package com.example.demo.web.controller;

import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.BooksSold;
import com.example.demo.data.entity.User;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class InformeController extends AbstractController<BooksSold>  {
    @PersistenceContext
    EntityManager entityManager;

    private static final String QUERY = "SELECT bs " +
            "FROM BooksSold bs " +
            "join bs.user usr " +
            "where usr.id = 3";
    private static final String QUERY1 =  "SELECT br " +
            "FROM BooksSold bs, BooksRead br  " +
            "where bs.books.id = br.books.id and  br.books.id > 10";
    private static final String QUERY2 =  "SELECT bs " +
            "FROM BooksSold bs, BooksRead br  " +
            "where bs.books.id = br.books.id and  br.books.id > 10";
    public List<BooksSold> queryInformeLibrosAdmin(){
        return (List<BooksSold>)  entityManager.createQuery(QUERY).getResultList();
    }
    public List<BooksRead> queryInformeLibrosLeidosAdmin(){
        return (List<BooksRead>)  entityManager.createQuery(QUERY1).getResultList();


    }
    public List<BooksSold> queryInformeLibrosVendidosAdmin(){
        return (List<BooksSold>)  entityManager.createQuery(QUERY2).getResultList();
    }

    @Autowired
    protected InformeController(MenuService menuService) {
        super(menuService);
    }
    @GetMapping("/informes")
    public String getAll(Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final List<BooksSold> all =queryInformeLibrosAdmin();
                model
                .addAttribute("username", user.getUserName())
                .addAttribute("listado", all);
        return "informes/list4";
    }

    @GetMapping("/informes/librosventas")
    public String getAlllibrosventas(Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final List<BooksSold> all_s = queryInformeLibrosVendidosAdmin();
        final List<BooksRead> all_r = queryInformeLibrosLeidosAdmin();
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("listado", all_r);
        return "informes/list6";
    }

}
