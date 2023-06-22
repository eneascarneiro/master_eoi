package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.EtiquetaEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtiquetaEmbeddableRepository extends JpaRepository<EtiquetaEmbeddable,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);

}
