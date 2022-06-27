package com.example.demo.service;

import com.example.demo.data.entity.Menu;
import com.example.demo.data.entity.Role;
import com.example.demo.data.entity.User;
import com.example.demo.data.repository.MenuRepository;
import com.example.demo.data.repository.RoleRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.MenuDTO;
import com.example.demo.service.mapper.MenuServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MenuService extends AbstractBusinessService<Menu, Integer, MenuDTO, MenuRepository, MenuServiceMapper> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    protected MenuService(MenuRepository repository, MenuServiceMapper serviceMapper,
            UserRepository userRepository, RoleRepository roleRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<MenuDTO> getMenuForUserId(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("The user ID %s does not exist", userId)));
        return getMenuForRole(user.getRoles());
    }

    public List<MenuDTO> getMenuForRole(Collection<Role> roles) {
        List<Menu> menus = this.getRepository().findDistinctByRolesIn(roles);
        return this.getServiceMapper().toDto(menus);
    }
}
