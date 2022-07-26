package com.example.demo.web.controller;

import com.example.demo.data.entity.Role;
import com.example.demo.data.entity.User;
import com.example.demo.data.entity.UserEmpresa;
import com.example.demo.dto.*;
import com.example.demo.service.*;
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

import java.util.List;
import java.util.Optional;

@Controller
public class UserEmpresaController extends AbstractController<UserEmpresaDTO>  {
    private final UserEmnpresaService service;
    private final EmpresaService empresaService;
    private int admin_profile;
    private boolean admin_profile_bool;

    private int role_id;

    @Autowired
    protected UserEmpresaController(MenuService menuService, UserEmnpresaService userEmnpresaService,
                                     EmpresaService empresaService) {
        super(menuService);
        this.service = userEmnpresaService;
        this.empresaService = empresaService;
    }


    @GetMapping("/userempresas")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<UserEmpresaDTO> all = this.service.findAll( PageRequest.of(page.orElse(1) - 1, size.orElse(10)));
            model
                    .addAttribute("username", user.getUserName())
                    .addAttribute("userempresa", all)
                    .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));

        return "userempresas/list";
    }

    @GetMapping("/userempresas/create")
    public String create(ModelMap model) {
        final UserEmpresaDTO dto = new UserEmpresaDTO();
        //Objeto userDTO
        UserDTO userDto = new UserDTO();
        userDto.setId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        dto.setUserDTO(userDto);
        model.addAttribute("userempresa", dto);
        return "userempresas/edit";
    }

    @Transactional
    @PostMapping(value = {"/userempresas/create" })
    public String save(UserEmpresaDTO dto) {
        System.out.println("creando el registro antes:" + dto.getTipo() + ": usuario :" + dto.getUserDTO().getId());
        //Hay que crear el registro de empresa
        EmpresaDTO empresaDTO =  empresaService.save(dto.getEmpresaDTO());
        dto.setEmpresaDTO(empresaDTO);
        return String.format("redirect:/bookssolds/%s", this.service.save(dto).getId());
    }

}
