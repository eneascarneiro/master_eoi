package com.app.gestionturnos.repository;

import com.app.gestionturnos.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //Añadir findall
    Page<Role> findAll(Pageable pageable);
}
