package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Absense;
import com.app.gestionturnos.model.Employee;

import java.util.List;

public interface AbsenseService {
    List<Absense> getAllAbsenses();

    List<Absense> getEmployeeAbsenses(Employee employee);

    void saveAbsense(Absense absense, Employee employee);

    Absense getAbsenseById(long id);

    void deleteAbsenseById(long id);
}
