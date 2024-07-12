package com.example.springdata.repository;

import com.example.springdata.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudDepartmentRepository extends JpaRepository<Department, Integer> {
}
