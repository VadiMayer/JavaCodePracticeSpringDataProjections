package com.example.springdata.service;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import com.example.springdata.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public List<EmployeeProjection> getEmployeesProjection() {
        return employeeRepository.getEmployeesProjection();
    }

    public EmployeeProjection getEmployeeProjectionById(int employeeId) {
        return employeeRepository.getEmployeeProjection(employeeId);
    }

    public EmployeeProjection create(Employee employee) {
        return employeeRepository.create(employee);
    }

    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    public void delete(int employeeId) {
        employeeRepository.delete(employeeId);
    }
}
