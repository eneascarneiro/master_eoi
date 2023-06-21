package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);
    List<Cliente> findClienteByEmpleado_Id(Integer id);
}
