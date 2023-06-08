package com.example.jpa_formacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jpa_formacion.model.TablaIzqTablaDerConDup;

@Repository
public interface TablaIzqTablaDerConDupRepository extends JpaRepository<TablaIzqTablaDerConDup,Long> {
}
