package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.BooksReadDTO;
import com.example.demo.service.BooksReadService;
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
public class BooksReadController extends AbstractController<BooksReadDTO>  {
    private final BooksReadService service;
    @Autowired
    protected BooksReadController(MenuService menuService, BooksReadService booksReadService) {
        super(menuService);
        this.service = booksReadService;
    }


    @GetMapping("/booksreads")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        if (user.getRoles().contains("ROLE_ADMIN")){
            final Page<BooksReadDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
            model
                    .addAttribute("username", user.getUserName())
                    .addAttribute("booksread", all)
                    .addAttribute("admin","")
                    .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        }
        else {
            final Page<BooksReadDTO> all = this.service.findByUserId(user.getId(), PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
            model
                    .addAttribute("username", user.getUserName())
                    .addAttribute("booksread", all)
                    .addAttribute("admin","hidden")
                    .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        }
        return "booksreads/list";
    }

    @GetMapping("/booksreads/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or #model[booksread].userId == authentication.principal.id")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("booksread", this.service.findById(id).get());
        return "booksreads/detail";
    }

    @GetMapping("/booksreads/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("booksread", this.service.findById(id).get());
        return "booksReads/edit";
    }

    @GetMapping("/booksreads/create")
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String create(ModelMap model) {
        final BooksReadDTO dto = new BooksReadDTO();
        dto.setUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("booksread", dto);
        return "booksreads/edit";
    }

    @Transactional
    @PostMapping(value = { "/booksreads/{id}/edit", "/booksreads/create" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public String save(BooksReadDTO dto) {
        return String.format("redirect:/booksreads/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/booksreads/{id}/delete" })
    @PostAuthorize("hasRole('ROLE_ADMIN') ")
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "booksread")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/booksReads");
        }
        status.setComplete();
        return "redirect:/booksreads";
    }
}
