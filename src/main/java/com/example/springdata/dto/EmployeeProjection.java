package com.example.springdata.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    String getFullName();

    String getPosition();

    String getDepartmentName();
}
