package com.example.jpa_formacion.repository;



import com.example.jpa_formacion.model.Libro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository  extends JpaRepository <Libro,Long> {
}

