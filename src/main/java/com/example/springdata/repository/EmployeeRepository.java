package com.example.springdata.repository;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeRepository {

    private CrudEmployeeRepository crudEmployeeRepository;

    public List<EmployeeProjection> getEmployeesProjection() {
        return crudEmployeeRepository.findAllEmployee();
    }

    public EmployeeProjection getEmployeeProjection(int employeeId) {
        return crudEmployeeRepository.findEmployeeProjection(employeeId);
    }

    public EmployeeProjection create(Employee employee) {
        Employee employeeFromBase = crudEmployeeRepository.save(employee);
        return getEmployeeProjection(employeeFromBase.getId());
    }

    public void update(Employee employee) {
        crudEmployeeRepository.save(employee);
    }

    public void delete(int employeeId) {
        crudEmployeeRepository.deleteById(employeeId);
    }
}
