package com.example.springdata.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();

    String getPosition();

    String getDepartmentName();
}
