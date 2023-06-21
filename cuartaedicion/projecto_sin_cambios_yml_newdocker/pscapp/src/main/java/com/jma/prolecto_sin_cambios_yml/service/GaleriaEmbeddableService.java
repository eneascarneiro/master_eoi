package com.jma.prolecto_sin_cambios_yml.service;



import com.jma.prolecto_sin_cambios_yml.model.GaleriaEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.GaleriaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class GaleriaEmbeddableService extends AbstractBusinessServiceSoloEnt<GaleriaEmbeddable,Integer,
        GaleriaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public GaleriaEmbeddableService(GaleriaEmbeddableRepository repo) {
        super(repo);
    }

}
