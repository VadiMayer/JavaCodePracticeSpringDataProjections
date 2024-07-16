package com.example.springdata.repository;

import com.example.springdata.dto.EmployeeProjection;
import com.example.springdata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CrudEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT CONCAT(e.lastName, ' ', e.firstName) as fullname, e.position as position, d.name as departmentName FROM Employee e JOIN Department d ON e.department.id=d.id WHERE e.id=:employeeId")
    EmployeeProjection findEmployeeProjection(@Param("employeeId") int employeeId);

    @Query(value = "SELECT CONCAT(e.lastName, ' ', e.firstName) as fullname, e.position as position, e.department.name as departmentName FROM Employee e")
    List<EmployeeProjection> findAllEmployee();

}
