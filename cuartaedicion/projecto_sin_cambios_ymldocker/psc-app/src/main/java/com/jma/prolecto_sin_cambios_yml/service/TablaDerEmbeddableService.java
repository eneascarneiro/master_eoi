package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.model.TablaDerEmbeddable;
import com.jma.prolecto_sin_cambios_yml.repository.TablaDerEmbeddableRepository;
import org.springframework.stereotype.Service;


@Service
public class TablaDerEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaDerEmbeddable,Long, TablaDerEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaDerEmbeddableService(TablaDerEmbeddableRepository repo) {
        super(repo);
    }

}
