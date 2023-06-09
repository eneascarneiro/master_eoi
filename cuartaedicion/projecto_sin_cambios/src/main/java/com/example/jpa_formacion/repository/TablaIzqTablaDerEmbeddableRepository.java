package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.GaleriaEtiquetaEmbeddable;
import com.example.jpa_formacion.model.TablaIzqTablaDerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TablaIzqTablaDerEmbeddableRepository extends JpaRepository<TablaIzqTablaDerEmbeddable,Long> {
    public  void deleteByReltabladerEmbeddableIdAndReltablaizqEmbeddableId(Long tabladerId,Long tablaizqId);
    Set<TablaIzqTablaDerEmbeddable> findAllByReltabladerEmbeddableId(Long id);

}