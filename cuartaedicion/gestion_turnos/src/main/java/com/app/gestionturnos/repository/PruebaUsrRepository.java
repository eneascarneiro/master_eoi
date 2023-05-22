package com.app.gestionturnos.repository;


import com.app.gestionturnos.model.PruebaUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaUsrRepository extends JpaRepository<PruebaUsr, Long>{}
