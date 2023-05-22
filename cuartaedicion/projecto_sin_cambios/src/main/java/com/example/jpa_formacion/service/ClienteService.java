package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.ClienteDto;
import com.example.jpa_formacion.model.Cliente;
import com.example.jpa_formacion.repository.ClienteRepository;
import com.example.jpa_formacion.service.mapper.ClienteMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class ClienteService extends AbstractBusinessService<Cliente,Integer, ClienteDto,
        ClienteRepository, ClienteMapper>  {
    //Acceso a los datos de la bbdd


    public ClienteService(ClienteRepository repo, ClienteMapper serviceMapper) {
        super(repo, serviceMapper);
    }


}
