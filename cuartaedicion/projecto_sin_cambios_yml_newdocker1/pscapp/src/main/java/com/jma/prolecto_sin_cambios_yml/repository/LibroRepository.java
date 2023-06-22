package com.jma.prolecto_sin_cambios_yml.repository;



import com.jma.prolecto_sin_cambios_yml.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository <Libro,Long> {
}

