package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.BooksDTO;
import com.example.demo.service.BooksService;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BooksController extends AbstractController<BooksDTO>  {
    private final BooksService service;
    @Autowired
    protected BooksController(MenuService menuService, BooksService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/books")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        Integer userConnected = 0;
        User user  = new User();
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            //No hay usuario conectado
            userConnected = 1;
            user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }

        final Page<BooksDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("conectado",userConnected)
                .addAttribute("books", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "books/list";
    }

    @GetMapping("/books/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("book", this.service.findById(id).get());
        return "books/detail";
    }

    @GetMapping("/books/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("book", this.service.findById(id).get());
        return "books/edit";
    }

    @GetMapping("/books/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final BooksDTO dto = new BooksDTO();
        model.addAttribute("book", dto);
        return "books/edit";
    }

    @Transactional
    @PostMapping(value = { "/books/{id}/edit", "/books/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(BooksDTO dto) {
        return String.format("redirect:/books/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/books/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "book")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/books");
        }
        status.setComplete();
        return "redirect:/books";
    }
}
