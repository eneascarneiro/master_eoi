package com.app.gestionturnos.repository;


import com.app.gestionturnos.model.Employee;
import com.app.gestionturnos.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {

  List<Vacation> findAllByEmployee(Employee employee);

}
