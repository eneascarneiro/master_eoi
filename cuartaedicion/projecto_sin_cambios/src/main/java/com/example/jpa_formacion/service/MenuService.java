package com.example.jpa_formacion.service;


import com.example.jpa_formacion.dto.MenuDTO;
import com.example.jpa_formacion.model.Menu;
import com.example.jpa_formacion.model.Role;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.repository.MenuRepository;
import com.example.jpa_formacion.repository.RoleRepository;
import com.example.jpa_formacion.repository.UsuarioRepository;
import com.example.jpa_formacion.service.mapper.MenuServiceMapper;
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
