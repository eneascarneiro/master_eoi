package com.example.jpa_formacion.service;


import com.example.jpa_formacion.model.EtiquetaEmbeddable;
import com.example.jpa_formacion.repository.EtiquetaEmbeddableRepository;
import com.example.jpa_formacion.repository.EtiquetaRepository;
import org.springframework.stereotype.Service;


@Service
public class EtiquetaEmbeddableService extends AbstractBusinessServiceSoloEnt<EtiquetaEmbeddable,Integer,
        EtiquetaEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public EtiquetaEmbeddableService(EtiquetaEmbeddableRepository repo) {
        super(repo);
    }

}
