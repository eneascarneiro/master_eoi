package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.ClienteDto;
import com.example.jpa_formacion.dto.EmpleadoDto;
import com.example.jpa_formacion.model.Cliente;
import com.example.jpa_formacion.model.Empleado;
import com.example.jpa_formacion.repository.ClienteRepository;
import com.example.jpa_formacion.repository.EmpleadoRepository;
import com.example.jpa_formacion.service.mapper.ClienteMapper;
import com.example.jpa_formacion.service.mapper.EmpleadoMapper;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoService extends AbstractBusinessService<Empleado,Integer, EmpleadoDto,
        EmpleadoRepository, EmpleadoMapper>  {
    //Acceso a los datos de la bbdd


    public EmpleadoService(EmpleadoRepository repo, EmpleadoMapper serviceMapper) {
        super(repo, serviceMapper);
    }


}
