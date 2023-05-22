package com.example.jpa_formacion.service;



import com.example.jpa_formacion.model.GaleriaEmbeddable;
import com.example.jpa_formacion.repository.GaleriaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class GaleriaEmbeddableService extends AbstractBusinessServiceSoloEnt<GaleriaEmbeddable,Integer,
        GaleriaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public GaleriaEmbeddableService(GaleriaEmbeddableRepository repo) {
        super(repo);
    }

}
