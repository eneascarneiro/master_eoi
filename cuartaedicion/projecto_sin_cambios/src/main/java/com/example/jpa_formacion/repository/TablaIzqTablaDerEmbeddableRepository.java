package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.TablaIzqTablaDerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaIzqTablaDerEmbeddableRepository extends JpaRepository<TablaIzqTablaDerEmbeddable,Long> {
}
