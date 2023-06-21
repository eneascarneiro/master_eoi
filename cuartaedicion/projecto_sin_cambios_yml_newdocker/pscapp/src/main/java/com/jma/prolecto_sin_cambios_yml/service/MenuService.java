package com.jma.prolecto_sin_cambios_yml.service;


import com.jma.prolecto_sin_cambios_yml.dto.MenuDTO;
import com.jma.prolecto_sin_cambios_yml.model.Menu;
import com.jma.prolecto_sin_cambios_yml.model.Role;
import com.jma.prolecto_sin_cambios_yml.model.Usuario;
import com.jma.prolecto_sin_cambios_yml.repository.MenuRepository;
import com.jma.prolecto_sin_cambios_yml.repository.RoleRepository;
import com.jma.prolecto_sin_cambios_yml.repository.UsuarioRepository;
import com.jma.prolecto_sin_cambios_yml.service.mapper.MenuServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MenuService extends AbstractBusinessService<Menu, Integer, MenuDTO, MenuRepository, MenuServiceMapper> {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;

    @Autowired
    protected MenuService(MenuRepository repository, MenuServiceMapper serviceMapper,
                          UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        super(repository, serviceMapper);
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
    }

    public List<MenuDTO> getMenuForUsuarioId(Integer usuarioId) {
        Usuario usuario = this.usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException(String.format("The user ID %s does not exist", usuarioId)));
        return getMenuForRole(usuario.getRoles());
    }

    public List<MenuDTO> getMenuForRole(Collection<Role> roles) {
        List<Menu> menus = this.getRepo().findDistinctByRolesInAndActiveTrue(roles);
        return this.getMapper().toDto(menus);
    }

    public List<MenuDTO> getMenuForEmail(String email) {
        Usuario usuario = this.usuarioRepository.findByEmailAndActiveTrue(email);
        return getMenuForRole(usuario.getRoles());
    }
}
