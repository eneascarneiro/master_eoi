package com.app.gestionturnos.service;


import com.app.gestionturnos.model.TipoEmpresa;
import com.app.gestionturnos.repository.TipoEmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEmpresaService extends AbstractBusinessServiceSoloEnt<TipoEmpresa,Long, TipoEmpresaRepository> {


    protected TipoEmpresaService(TipoEmpresaRepository tipoEmpresaRepository) {
        super(tipoEmpresaRepository);
    }

}
