package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.model.Empresa;
import com.app.gestionturnos.repository.EmpresaRepository;
import com.app.gestionturnos.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class APPEmpresaController  extends AbstractController <Empresa> {

    @Autowired
    EmpresaRepository empresaRepository;

    protected APPEmpresaController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping("/empresas/listaempresas")
    public String getAllEmpresas(ModelMap interfazConPantalla) {
        //generamos el contenedor
        List<Empresa> empresas = new ArrayList<>();

        //Leemos dentro del array el contenido del modelo virtual desde el repositorio
        empresaRepository.findAll().forEach(empresas::add);
        interfazConPantalla.addAttribute("lista", empresas);
        return "empresas/all";
    }

}
