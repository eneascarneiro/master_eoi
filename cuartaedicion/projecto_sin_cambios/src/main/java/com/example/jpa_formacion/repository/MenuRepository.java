package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.Menu;
import com.example.jpa_formacion.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findDistinctByRolesIn(Collection<Role> roles);

    List<Menu> findDistinctByRolesInAndActiveTrue(Collection<Role> roles);
}
