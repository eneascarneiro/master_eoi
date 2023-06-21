package com.jma.prolecto_sin_cambios_yml.service;

import com.jma.prolecto_sin_cambios_yml.dto.RoleDTO;
import com.jma.prolecto_sin_cambios_yml.model.Role;
import com.jma.prolecto_sin_cambios_yml.repository.RoleRepository;
import com.jma.prolecto_sin_cambios_yml.repository.UsuarioRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.RoleServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractBusinessService<Role, Integer, RoleDTO, RoleRepository, RoleServiceMapper> {

    private final UsuarioRepository usuarioRepository;

    protected RoleService(RoleRepository repository, RoleServiceMapper serviceMapper, UsuarioRepository usuarioRepository) {
        super(repository, serviceMapper);
        this.usuarioRepository = usuarioRepository;
    }

}
