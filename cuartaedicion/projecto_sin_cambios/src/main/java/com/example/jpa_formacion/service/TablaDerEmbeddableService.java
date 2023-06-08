package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.TablaDerEmbeddable;
import com.example.jpa_formacion.model.TablaIzqEmbeddable;
import com.example.jpa_formacion.repository.TablaDerEmbeddableRepository;
import com.example.jpa_formacion.repository.TablaIzqEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class TablaDerEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaDerEmbeddable,Long, TablaDerEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaDerEmbeddableService(TablaDerEmbeddableRepository repo) {
        super(repo);
    }

}
