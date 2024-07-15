package com.example.springdata.repository;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CrudEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e.lastName, e.firstName, d.name FROM Employee e JOIN Department d ON e.id=:employeeId")
    EmployeeProjection findEmployeeProjection(@Param("employeeId") int employeeId);

    @Query("SELECT e.lastName, e.firstName, e.department.name as departmentName FROM Employee e")
    List<EmployeeProjection> findAllEmployee();

}
