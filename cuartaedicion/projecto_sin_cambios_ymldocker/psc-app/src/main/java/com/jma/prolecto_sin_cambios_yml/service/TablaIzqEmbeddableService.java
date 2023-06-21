package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.TablaIzqEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.TablaIzqEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class TablaIzqEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaIzqEmbeddable,Long, TablaIzqEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaIzqEmbeddableService(TablaIzqEmbeddableRepository repo) {
        super(repo);
    }

}
