package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.Cliente;
import com.example.jpa_formacion.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EtiquetaRepository extends JpaRepository<Etiqueta,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);

}
