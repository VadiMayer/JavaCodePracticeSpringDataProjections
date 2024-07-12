package com.example.springdata.controller;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeProjection> get() {
        return employeeService.get();
    }
}
