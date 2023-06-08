package com.example.jpa_formacion.repository;

import com.example.jpa_formacion.model.TablaDerEmbeddable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablaDerConDupRepository extends JpaRepository<TablaDerEmbeddable,Long> {
}
