package com.example.demo.service;

import com.example.demo.data.entity.Role;
import com.example.demo.data.repository.RoleRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.RoleDTO;
import com.example.demo.service.mapper.RoleServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractBusinessService<Role, Integer, RoleDTO, RoleRepository, RoleServiceMapper> {

    private final UserRepository userRepository;

    protected RoleService(RoleRepository repository, RoleServiceMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado del los libros
    public Page<RoleDTO> findAll( Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

}
