package com.example.demo.web.controller;

import com.example.demo.data.entity.Role;
import com.example.demo.data.entity.User;
import com.example.demo.dto.BooksDTO;
import com.example.demo.dto.BooksSoldDTO;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.BooksSoldService;
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

import java.util.Collection;
import java.util.Optional;

@Controller
public class BooksSoldController extends AbstractController<BooksSoldDTO>  {
    private final BooksSoldService service;
    @Autowired
    protected BooksSoldController(MenuService menuService, BooksSoldService booksSoldService) {
        super(menuService);
        this.service = booksSoldService;
    }


    @GetMapping("/bookssolds")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        if (user.getRoles().contains("ROLE_ADMIN")){
            final Page<BooksSoldDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
            model
                    .addAttribute("username", user.getUserName())
                    .addAttribute("bookssold", all)
                    .addAttribute("admin","")
                    .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        }
        else {
            final Page<BooksSoldDTO> all = this.service.findByUserId(user.getId(), PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
            model
                    .addAttribute("username", user.getUserName())
                    .addAttribute("bookssold", all)
                    .addAttribute("admin","hidden")
                    .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        }
        return "bookssolds/list";
    }

    @GetMapping("/bookssolds/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or #model[books_sold].userId == authentication.principal.id")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("bookssold", this.service.findById(id).get());
        return "bookssolds/detail";
    }

    @GetMapping("/bookssolds/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("bookssold", this.service.findById(id).get());
        return "bookssolds/edit";
    }

    @GetMapping("/bookssolds/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final BooksSoldDTO dto = new BooksSoldDTO();
        dto.setUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("bookssold", dto);
        return "bookssolds/edit";
    }

    @Transactional
    @PostMapping(value = { "/bookssolds/{id}/edit", "/bookssolds/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(BooksSoldDTO dto) {
        return String.format("redirect:/bookssolds/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/bookssolds/{id}/delete" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "bookssold")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/bookssolds");
        }
        status.setComplete();
        return "redirect:/bookssolds";
    }
}
