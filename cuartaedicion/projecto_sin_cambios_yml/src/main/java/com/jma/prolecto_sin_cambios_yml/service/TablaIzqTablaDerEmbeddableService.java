package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.TablaIzqTablaDerEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.TablaIzqTablaDerEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class TablaIzqTablaDerEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaIzqTablaDerEmbeddable,Long, TablaIzqTablaDerEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaIzqTablaDerEmbeddableService(TablaIzqTablaDerEmbeddableRepository repo) {
        super(repo);
    }

}
