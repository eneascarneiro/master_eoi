package com.app.gestionturnos.service;

import com.app.gestionturnos.dto.RoleDTO;
import com.app.gestionturnos.model.Role;
import com.app.gestionturnos.repository.RoleRepository;
import com.app.gestionturnos.repository.UsuarioRepository;
import com.app.gestionturnos.service.mapper.RoleServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractBusinessService<Role, Integer, RoleDTO, RoleRepository, RoleServiceMapper> {

    private final UsuarioRepository usuarioRepository;

    protected RoleService(RoleRepository repository, RoleServiceMapper serviceMapper, UsuarioRepository usuarioRepository) {
        super(repository, serviceMapper);
        this.usuarioRepository = usuarioRepository;
    }



}
