package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Employee;
import com.app.gestionturnos.model.Vacation;

import java.util.List;

public interface VacationService {
    List<Vacation> getAllVacations();

    List<Vacation> getEmployeeVacations(Employee employee);

    void saveVacation(Vacation vacation, Employee employee);

    Vacation getVacationById(long id);

    void deleteVacationById(long id);
}
