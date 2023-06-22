package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.TablaIzqTablaDerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TablaIzqTablaDerEmbeddableRepository extends JpaRepository<TablaIzqTablaDerEmbeddable,Long> {
    public  void deleteByReltabladerEmbeddableIdAndReltablaizqEmbeddableId(Long tabladerId,Long tablaizqId);
    Set<TablaIzqTablaDerEmbeddable> findAllByReltabladerEmbeddableId(Long id);

}