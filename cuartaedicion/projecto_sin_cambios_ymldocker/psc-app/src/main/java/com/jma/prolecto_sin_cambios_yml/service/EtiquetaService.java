package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.EtiquetaDto;
import com.jma.prolecto_sin_cambios_yml.model.Etiqueta;
import com.jma.prolecto_sin_cambios_yml.repository.EtiquetaRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.EtiquetaMapper;
import org.springframework.stereotype.Service;


@Service
public class EtiquetaService extends AbstractBusinessService<Etiqueta,Integer, EtiquetaDto,
        EtiquetaRepository, EtiquetaMapper>  {
    //Acceso a los datos de la bbdd


    public EtiquetaService(EtiquetaRepository repo, EtiquetaMapper serviceMapper) {
        super(repo, serviceMapper);
    }




}
