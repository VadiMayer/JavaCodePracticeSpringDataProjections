package com.example.springdata.repository;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CrudEmployeeRepository extends JpaRepository<Employee, Integer> {


    List<EmployeeProjection> get();
}
