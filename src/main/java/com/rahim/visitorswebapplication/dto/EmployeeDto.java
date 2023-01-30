package com.rahim.visitorswebapplication.dto;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import lombok.Data;

@Data
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private EmployeeRole role;
}
