package com.example.springdata.service;

import com.example.springdata.model.Department;
import com.example.springdata.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    public Department get(int departmentId) {
        return departmentRepository.get(departmentId);
    }

    public Department create(Department department) {
        return departmentRepository.create(department);
    }
}
