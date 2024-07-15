package com.example.springdata.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeProjection {

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();

    @Value("#{target.position}")
    String getPosition();

    String getDepartmentName();
}
