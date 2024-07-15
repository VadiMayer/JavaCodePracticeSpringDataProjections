package com.example.springdata.controller;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import com.example.springdata.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeProjection> getEmployeesProjection() {
        return employeeService.getEmployeesProjection();
    }

    @GetMapping("/{id}")
    public EmployeeProjection getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeProjectionById(id);
    }

    @PostMapping
    public EmployeeProjection create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
