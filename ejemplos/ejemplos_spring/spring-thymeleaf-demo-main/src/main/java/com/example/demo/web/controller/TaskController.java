package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.MenuService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class TaskController extends AbstractController<TaskDTO> {

    private final TaskService service;

    @Autowired
    public TaskController(MenuService menuService, TaskService service) {
        super(menuService);
        this.service = service;
    }

    @GetMapping("/tasks")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
            Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<TaskDTO> all = this.service.findAll(user.getId(), PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("tasks", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "tasks/list";
    }

    @GetMapping("/tasks/{id}")
    @PostAuthorize("hasRole('ROLE_ADMIN') or #model[task].userId == authentication.principal.id")
    public String detail(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("task", this.service.findById(id).get());
        return "tasks/detail";
    }

    @GetMapping("/tasks/{id}/edit")
    @PostAuthorize("hasRole('ROLE_ADMIN') or #model[task].userId == authentication.principal.id")
    public String edit(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("task", this.service.findById(id).get());
        return "tasks/edit";
    }

    @GetMapping("/tasks/create")
    public String create(ModelMap model) {
        final TaskDTO dto = new TaskDTO();
        dto.setUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("task", dto);
        return "tasks/edit";
    }

    @Transactional
    @PostMapping(value = { "/tasks/{id}/edit", "/tasks/create" })
    public String save(TaskDTO dto) {
        return String.format("redirect:/tasks/%s", this.service.save(dto).getId());
    }

    @PostMapping({ "/tasks/{id}/delete" })
    public Object delete(@PathVariable(value = "id") Integer id, SessionStatus status) {
        try {
            this.service.delete(id);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", id)
                    .addObject("entityName", "task")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink", "/tasks");
        }
        status.setComplete();
        return "redirect:/tasks";
    }
}
