package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.BooksDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.BooksService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;
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
public class UserController extends AbstractController<UserDTO>  {
    private final UserService service;
    @Autowired
    protected UserController(MenuService menuService, UserService servicio) {
        super(menuService);
        this.service = servicio;
    }
    @GetMapping("/users")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<UserDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("users", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "users/list";
    }

    @GetMapping("/users/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("user", this.service.findById(id).get());
        return "users/detail";
    }

    @GetMapping("/users/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("user", this.service.findById(id).get());
        return "users/edit";
    }

    @GetMapping("/users/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final UserDTO dto = new UserDTO();
        model.addAttribute("user", dto);
        return "users/edit";
    }

    @Transactional
    @PostMapping(value = { "/users/{id}/edit", "/users/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(UserDTO dto) {
        return String.format("redirect:/users/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/users/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "user")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/users");
        }
        status.setComplete();
        return "redirect:/users";
    }
}
