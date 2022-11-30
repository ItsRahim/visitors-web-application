package com.rahim.visitorswebapplication.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmployeeRole {
    HOME_MANAGER,
    RECEPTIONIST,
    CARER,
    ACTIVITIES_COORDINATOR;

    @Getter
    public String employeeRoles;
}
