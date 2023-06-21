package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtiquetaRepository extends JpaRepository<Etiqueta,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);

}
