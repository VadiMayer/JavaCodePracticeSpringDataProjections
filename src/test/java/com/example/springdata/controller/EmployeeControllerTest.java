package com.example.springdata.controller;

import com.example.springdata.model.Department;
import com.example.springdata.model.Employee;
import com.example.springdata.repository.DepartmentRepository;
import com.example.springdata.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Sql("classpath:db/initDB.sql")
class EmployeeControllerTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        List<Department> departmentList = List.of(
                new Department("The Board of Directors"),
                new Department("Design Department"),
                new Department("Cinematography Department"),
                new Department("Marketing Department"));
        for (Department department : departmentList) {
            departmentRepository.create(department);
        }
        List<Employee> employeeList = List.of(
                new Employee("Vadim", "Kulagin", "Director", 5000000, new Department(1, "The Board of Directors")),
                new Employee("Kirill", "Demin", "Deputy Director", 2000000, new Department(1, "The Board of Directors")),
                new Employee("Gosha", "G", "Main Designer", 1000000, new Department(2, "Design Department")),
                new Employee("Ilia", "I", "Main Videographer", 1500000, new Department(3, "Cinematography Department")),
                new Employee("Katia", "Kulagina", "Chief Marketing Officer", 5000000, new Department(4, "Marketing Department"))
        );
        for (Employee employee : employeeList) {
            employeeRepository.create(employee);
        }
    }

    @Test
    void getEmployeesProjection() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employeeRepository.getEmployeesProjection())));
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}