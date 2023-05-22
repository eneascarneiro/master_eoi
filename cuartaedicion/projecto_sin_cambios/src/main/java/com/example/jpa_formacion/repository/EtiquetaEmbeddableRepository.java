package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.EtiquetaEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtiquetaEmbeddableRepository extends JpaRepository<EtiquetaEmbeddable,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);

}
