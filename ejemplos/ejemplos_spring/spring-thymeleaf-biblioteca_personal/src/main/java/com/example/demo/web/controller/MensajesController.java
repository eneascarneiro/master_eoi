package com.example.demo.web.controller;

import com.example.demo.data.entity.User;
import com.example.demo.dto.MensajesDTO;
import com.example.demo.service.MensajesService;
import com.example.demo.service.MenuService;
import com.example.demo.service.PublicarMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Controller
public class MensajesController extends AbstractController<MensajesDTO>  {
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    private final MensajesService service;
    private final PublicarMensaje publicarMensaje;
    @Autowired
    protected MensajesController(MenuService menuService, MensajesService servicio, PublicarMensaje publicarMensaje) {
        super(menuService);
        this.service = servicio;
        this.publicarMensaje = publicarMensaje;
    }
    @GetMapping("/mensajes")
    public String getAll(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
                         Model model) {
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        final Page<MensajesDTO> all = this.service.findByUserId(user.getId(), PageRequest.of(page.orElse(1) - 1,
                            size.orElse(10)));
        model
                .addAttribute("username", user.getUserName())
                .addAttribute("mensajes", all)
                .addAttribute(pageNumbersAttributeKey, getPageNumbers(all));
        return "mensajes/list";
    }

    @GetMapping("/mensajes/create")
    public String create(ModelMap model) {
        final MensajesDTO dto = new MensajesDTO();
        model.addAttribute("mensaje", dto);
        return "mensajes/edit";
    }

    @Transactional
    @PostMapping(value = { "/mensajes/create" })
    public String save(MensajesDTO dto) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        dto.setUserId(user.getId() );
        String mensaje = dto.getMensaje();
        mensaje += ":";
        mensaje += sdf1.format(timestamp);
        dto.setMensaje(mensaje);
        //Generar evento
        publicarMensaje.EnviarMensajeSaludo(dto) ;
        return "redirect:/mensajes";
    }
}
