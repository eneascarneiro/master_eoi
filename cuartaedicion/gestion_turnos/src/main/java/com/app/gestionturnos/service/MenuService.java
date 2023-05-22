package com.app.gestionturnos.service;


import com.app.gestionturnos.model.Menu;
import com.app.gestionturnos.model.Role;
import com.app.gestionturnos.model.Usuario;
import com.app.gestionturnos.repository.MenuRepository;
import com.app.gestionturnos.repository.RoleRepository;
import com.app.gestionturnos.repository.UsuarioRepository;
import com.app.gestionturnos.service.mapper.MenuServiceMapper;
import com.app.gestionturnos.dto.MenuDTO;
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
        List<Menu> menus = this.getRepo().findDistinctByRolesInAndActiveTrueOrderByOrder(roles);
        return this.getMapper().toDto(menus);
    }

    public List<MenuDTO> getMenuForEmail(String email) {
        System.out.println("getMenuForEmail: " + email);
        Usuario usuario = this.usuarioRepository.findByEmailAndActiveTrue(email);

        return getMenuForRole(usuario.getRoles());
    }
}
