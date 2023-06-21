package com.jma.prolecto_sin_cambios_yml.repository;


import com.jma.prolecto_sin_cambios_yml.model.GaleriaEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface GaleriaEmbeddableRepository extends JpaRepository<GaleriaEmbeddable,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);
}
