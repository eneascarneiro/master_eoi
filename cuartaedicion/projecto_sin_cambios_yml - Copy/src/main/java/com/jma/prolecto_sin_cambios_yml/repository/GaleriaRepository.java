package com.jma.prolecto_sin_cambios_yml.repository;

import com.jma.prolecto_sin_cambios_yml.model.Galeria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GaleriaRepository extends JpaRepository<Galeria,Integer>{
    //List<Cliente> findBynombreCliente(String nombre);

    List<Galeria>  findGaleriaByUrlImgIsLike(String url);
    List<Galeria>  findGaleriaByEmpleadoGaleria_Email(String email);

    List<Galeria>  findGaleriaByEmpleadoGaleria_Apellido1(String apll);

    Galeria findGaleriaById(Integer id);
}
