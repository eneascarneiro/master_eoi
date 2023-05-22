package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.EtiquetaDto;
import com.example.jpa_formacion.dto.GaleriaDto;
import com.example.jpa_formacion.model.Etiqueta;
import com.example.jpa_formacion.model.Galeria;
import com.example.jpa_formacion.repository.EtiquetaRepository;
import com.example.jpa_formacion.repository.GaleriaRepository;
import com.example.jpa_formacion.service.mapper.EtiquetaMapper;
import com.example.jpa_formacion.service.mapper.GaleriaMapper;
import org.springframework.stereotype.Service;


@Service
public class GaleriaService extends AbstractBusinessService<Galeria,Integer, GaleriaDto,
        GaleriaRepository, GaleriaMapper>  {
    //Acceso a los datos de la bbdd


    public GaleriaService(GaleriaRepository repo, GaleriaMapper serviceMapper) {
        super(repo, serviceMapper);
    }

}
