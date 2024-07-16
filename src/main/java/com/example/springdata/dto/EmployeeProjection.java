package com.example.springdata.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    String getPosition();

    String getDepartmentName();
}
