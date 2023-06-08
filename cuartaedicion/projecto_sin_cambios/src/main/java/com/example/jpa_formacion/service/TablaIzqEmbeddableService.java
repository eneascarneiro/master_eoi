package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.model.TablaIzqEmbeddable;
import com.example.jpa_formacion.repository.EtiquetaRepository;
import com.example.jpa_formacion.repository.TablaIzqEmbeddableRepository;
import com.example.jpa_formacion.service.mapper.EtiquetaMapper;
import org.springframework.stereotype.Service;


@Service
public class TablaIzqEmbeddableService extends AbstractBusinessServiceSoloEnt <TablaIzqEmbeddable,Long, TablaIzqEmbeddableRepository>  {
    //Acceso a los datos de la bbdd


    public TablaIzqEmbeddableService(TablaIzqEmbeddableRepository repo) {
        super(repo);
    }

}
