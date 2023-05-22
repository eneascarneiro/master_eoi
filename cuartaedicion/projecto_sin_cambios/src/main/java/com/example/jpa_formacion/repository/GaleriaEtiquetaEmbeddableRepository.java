package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.GaleriaEtiquetaEmbeddable;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface GaleriaEtiquetaEmbeddableRepository extends JpaRepository<GaleriaEtiquetaEmbeddable,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);
    @Transactional
    void deleteByEtiquetaEmbeddableIdAndGaleriaEmbeddableId(Long etiquetaEmbedId, Long  galeriaEmbedId );
    Set<GaleriaEtiquetaEmbeddable> findAllByGaleriaEmbeddable_Id(Long id);
}
