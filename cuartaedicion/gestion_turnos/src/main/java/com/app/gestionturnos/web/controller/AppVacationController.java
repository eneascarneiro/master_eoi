package com.app.gestionturnos.web.controller;

import com.app.gestionturnos.model.Employee;
import com.app.gestionturnos.model.Vacation;

import com.app.gestionturnos.service.EmployeeService;

import com.app.gestionturnos.service.VacationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacations")
public class AppVacationController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("vacations", vacationService.getAllVacations());
        return "vacations/all";
    }

    // @GetMapping("/new")
    // public String showNewEmployeeForm(Model model) {
    // model.addAttribute("employee", new Employee());
    // return "employees/new";
    // }

    @PostMapping("/save/{employee_id}")
    public String saveVacation(@ModelAttribute("vacation") Vacation vacation,
            @PathVariable(value = "employee_id") long id) {
        Employee employee = employeeService.getEmployeeById(id);

        vacationService.saveVacation(vacation, employee);
        return "redirect:/employees/details/" + employee.getId();
    }

    // @GetMapping("/details/{id}")
    // public String details(@PathVariable(value = "id") long id, Model model) {
    // Employee employee = vacationService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/details";
    // }

    // @GetMapping("/edit/{id}")
    // public String showFormForUpdate(@PathVariable(value = "id") long id, Model
    // model) {
    // Employee employee = vacationService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/edit";
    // }

    // @GetMapping("/delete/{id}")
    // public String deleteEmployee(@PathVariable(value = "id") long id) {

    // this.vacationService.deleteEmployeeById(id);
    // return "redirect:/employees/all";
    // }
}
