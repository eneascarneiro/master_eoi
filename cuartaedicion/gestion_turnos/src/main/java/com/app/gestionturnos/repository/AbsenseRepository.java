package com.app.gestionturnos.repository;

import com.app.gestionturnos.model.Absense;

import com.app.gestionturnos.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenseRepository extends JpaRepository<Absense, Long> {

  List<Absense> findAllByEmployee(Employee employee);

}
