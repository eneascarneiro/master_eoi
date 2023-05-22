package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);
    List<Cliente> findClienteByEmpleado_Id(Integer id);
}
