package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.ClienteDto;
import com.jma.prolecto_sin_cambios_yml.model.Cliente;
import com.jma.prolecto_sin_cambios_yml.repository.ClienteRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.ClienteMapper;
import org.springframework.stereotype.Service;


@Service
public class ClienteService extends AbstractBusinessService<Cliente,Integer, ClienteDto,
        ClienteRepository, ClienteMapper>  {
    //Acceso a los datos de la bbdd


    public ClienteService(ClienteRepository repo, ClienteMapper serviceMapper) {
        super(repo, serviceMapper);
    }


}
