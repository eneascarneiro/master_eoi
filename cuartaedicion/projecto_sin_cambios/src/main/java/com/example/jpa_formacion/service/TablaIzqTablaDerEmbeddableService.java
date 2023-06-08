package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.TablaDerEmbeddable;
import com.example.jpa_formacion.model.TablaIzqTablaDerEmbeddable;
import com.example.jpa_formacion.repository.TablaDerEmbeddableRepository;
import com.example.jpa_formacion.repository.TablaIzqEmbeddableRepository;
import com.example.jpa_formacion.repository.TablaIzqTablaDerEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class TablaIzqTablaDerEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaIzqTablaDerEmbeddable,Long, TablaIzqTablaDerEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaIzqTablaDerEmbeddableService(TablaIzqTablaDerEmbeddableRepository repo) {
        super(repo);
    }

}
