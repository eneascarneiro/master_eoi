package com.app.gestionturnos.repository;


import com.app.gestionturnos.model.Menu;
import com.app.gestionturnos.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findDistinctByRolesIn(Collection<Role> roles);

    List<Menu> findDistinctByRolesInAndActiveTrue(Collection<Role> roles);

    List<Menu> findDistinctByRolesInAndActiveTrueOrderByOrder (Collection<Role> roles);
}
