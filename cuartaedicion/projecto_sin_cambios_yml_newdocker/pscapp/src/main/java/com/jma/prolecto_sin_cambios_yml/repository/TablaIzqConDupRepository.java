package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.TablaIzqEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaIzqConDupRepository extends JpaRepository<TablaIzqEmbeddable,Long> {
}
