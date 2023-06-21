package com.jma.prolecto_sin_cambios_yml.service;



import com.jma.prolecto_sin_cambios_yml.model.GaleriaEtiquetaEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.GaleriaEtiquetaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class GaleriaEtiquetaEmbeddableService extends AbstractBusinessServiceSoloEnt<GaleriaEtiquetaEmbeddable,Integer,
        GaleriaEtiquetaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public GaleriaEtiquetaEmbeddableService(GaleriaEtiquetaEmbeddableRepository repo) {
        super(repo);
    }

}
