package com.example.jpa_formacion.service;



import com.example.jpa_formacion.model.GaleriaEmbeddable;
import com.example.jpa_formacion.model.GaleriaEtiquetaEmbeddable;
import com.example.jpa_formacion.repository.GaleriaEmbeddableRepository;
import com.example.jpa_formacion.repository.GaleriaEtiquetaEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class GaleriaEtiquetaEmbeddableService extends AbstractBusinessServiceSoloEnt<GaleriaEtiquetaEmbeddable,Integer,
        GaleriaEtiquetaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public GaleriaEtiquetaEmbeddableService(GaleriaEtiquetaEmbeddableRepository repo) {
        super(repo);
    }

}
