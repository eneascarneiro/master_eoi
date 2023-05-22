package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.GaleriaEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GaleriaEmbeddableRepository extends JpaRepository<GaleriaEmbeddable,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);
}
