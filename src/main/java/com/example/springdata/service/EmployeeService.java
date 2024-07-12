package com.example.springdata.service;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public List<EmployeeProjection> get() {
        return null;
    }
}
