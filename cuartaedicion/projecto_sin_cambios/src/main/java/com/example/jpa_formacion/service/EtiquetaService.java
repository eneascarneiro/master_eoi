package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.EtiquetaDtoApi;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.repository.EtiquetaRepository;
import com.example.jpa_formacion.service.mapper.EtiquetaMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class EtiquetaService extends AbstractBusinessService<Etiqueta,Integer, EtiquetaDto,
        EtiquetaRepository, EtiquetaMapper>  {
    //Acceso a los datos de la bbdd


    public EtiquetaService(EtiquetaRepository repo, EtiquetaMapper serviceMapper) {
        super(repo, serviceMapper);
    }


    public List<EtiquetaDtoApi> buscartodosapi(){
        return  this.serviceMapper.toDtoApi(this.getRepo().findAll());
    }
}
