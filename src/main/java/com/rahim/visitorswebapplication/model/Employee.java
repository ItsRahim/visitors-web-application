package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.helper.EmployeeHelper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
public class Employee {
//    @Transient
//    EmployeeHelper employeeHelper;

    @Id
    @Column(unique = true)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private LocalDate dob;

    @Column(unique = true)
    private String email;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    public Employee(String firstName, String lastName, LocalDate dob, LocalDate startDate, EmployeeRole role) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = EmployeeHelper.emailFormatter(this.firstName, this.lastName);
        this.startDate = startDate;
        this.role = role;
    }
}
