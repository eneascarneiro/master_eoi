package com.jma.prolecto_sin_cambios_yml.service;


import com.jma.prolecto_sin_cambios_yml.model.EtiquetaEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.EtiquetaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class EtiquetaEmbeddableService extends AbstractBusinessServiceSoloEnt<EtiquetaEmbeddable,Integer,
        EtiquetaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public EtiquetaEmbeddableService(EtiquetaEmbeddableRepository repo) {
        super(repo);
    }

}
