package com.jma.prolecto_sin_cambios_yml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jma.prolecto_sin_cambios_yml.model.TablaIzqTablaDerConDup;

@Repository
public interface TablaIzqTablaDerConDupRepository extends JpaRepository<TablaIzqTablaDerConDup,Long> {
}
