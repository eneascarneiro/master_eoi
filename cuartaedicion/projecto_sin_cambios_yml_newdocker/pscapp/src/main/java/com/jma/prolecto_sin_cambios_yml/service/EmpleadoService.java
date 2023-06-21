package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.EmpleadoDto;
import com.jma.prolecto_sin_cambios_yml.model.Empleado;
import com.jma.prolecto_sin_cambios_yml.repository.EmpleadoRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.EmpleadoMapper;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoService extends AbstractBusinessService<Empleado,Integer, EmpleadoDto,
        EmpleadoRepository, EmpleadoMapper>  {
    //Acceso a los datos de la bbdd


    public EmpleadoService(EmpleadoRepository repo, EmpleadoMapper serviceMapper) {
        super(repo, serviceMapper);
    }


}
