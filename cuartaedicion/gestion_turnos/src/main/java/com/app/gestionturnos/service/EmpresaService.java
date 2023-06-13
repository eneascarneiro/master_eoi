package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Employee;
import com.app.gestionturnos.model.Empresa;
import com.app.gestionturnos.repository.EmpresaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService extends  AbstractBusinessServiceSoloEnt<Empresa, Long, EmpresaRepository> {

    protected EmpresaService(EmpresaRepository empresaRepository) {
        super(empresaRepository);
    }
}
