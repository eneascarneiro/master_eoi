package com.jma.prolecto_sin_cambios_yml.repository;


import com.jma.prolecto_sin_cambios_yml.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
}
