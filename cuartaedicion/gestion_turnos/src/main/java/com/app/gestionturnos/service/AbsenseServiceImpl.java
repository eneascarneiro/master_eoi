package com.app.gestionturnos.service;

import com.app.gestionturnos.model.Absense;
import com.app.gestionturnos.model.Employee;
import com.app.gestionturnos.repository.AbsenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenseServiceImpl implements AbsenseService {

    @Autowired
    private AbsenseRepository absenseRepository;

    @Override
    public List<Absense> getAllAbsenses() {
        return absenseRepository.findAll();
    }

    @Override
    public Absense getAbsenseById(long id) {
        Optional<Absense> optional = absenseRepository.findById(id);
        Absense Absense = null;
        if (optional.isPresent()) {
            Absense = optional.get();
        } else {
            throw new RuntimeException(" Absense not found for id :: " + id);
        }
        return Absense;
    }

    @Override
    public void deleteAbsenseById(long id) {
        this.absenseRepository.deleteById(id);
    }

    @Override
    public void saveAbsense(Absense Absense, Employee employee) {
        Absense _Absense = Absense;
        Absense.setEmployee(employee);
        this.absenseRepository.save(_Absense);
    }

    @Override
    public List<Absense> getEmployeeAbsenses(Employee employee) {
        return absenseRepository.findAllByEmployee(employee);
    }
}
