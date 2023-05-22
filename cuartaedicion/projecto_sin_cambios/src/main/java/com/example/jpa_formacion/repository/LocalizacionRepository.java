package com.example.jpa_formacion.repository;



import com.example.jpa_formacion.model.Localizacion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacionRepository  extends JpaRepository <Localizacion,Long> {
}

