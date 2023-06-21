package com.jma.prolecto_sin_cambios_yml.service;



import com.jma.prolecto_sin_cambios_yml.model.CompraSimplificada;
import com.jma.prolecto_sin_cambios_yml.repository.CompraSimplificadaRepository;
import org.springframework.stereotype.Service;


@Service
public class CompraSimplificadaService extends AbstractBusinessServiceSoloEnt<CompraSimplificada,Integer,
        CompraSimplificadaRepository>  {
    //Acceso a los datos de la bbdd


    public CompraSimplificadaService(CompraSimplificadaRepository repo) {
        super(repo);
    }

}
