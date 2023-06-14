package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.GaleriaDto;
import com.jma.prolecto_sin_cambios_yml.model.Galeria;
import com.jma.prolecto_sin_cambios_yml.repository.GaleriaRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.GaleriaMapper;
import org.springframework.stereotype.Service;


@Service
public class GaleriaService extends AbstractBusinessService<Galeria,Integer, GaleriaDto,
        GaleriaRepository, GaleriaMapper>  {
    //Acceso a los datos de la bbdd


    public GaleriaService(GaleriaRepository repo, GaleriaMapper serviceMapper) {
        super(repo, serviceMapper);
    }

}
