package com.example.springdata.repository;


import com.example.springdata.model.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DepartmentRepository {
    private CrudDepartmentRepository crudDepartmentRepository;

    public Department get(int departmentId) {
        return crudDepartmentRepository.findById(departmentId).orElse(null);
    }

    public Department create(Department department) {
        return crudDepartmentRepository.save(department);
    }
}
