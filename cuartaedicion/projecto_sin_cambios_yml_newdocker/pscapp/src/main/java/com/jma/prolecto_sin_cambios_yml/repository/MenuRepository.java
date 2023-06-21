package com.jma.prolecto_sin_cambios_yml.repository;


import com.jma.prolecto_sin_cambios_yml.model.Menu;
import com.jma.prolecto_sin_cambios_yml.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findDistinctByRolesIn(Collection<Role> roles);

    List<Menu> findDistinctByRolesInAndActiveTrue(Collection<Role> roles);


}
