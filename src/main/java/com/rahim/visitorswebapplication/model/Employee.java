package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import com.rahim.visitorswebapplication.helper.EmployeeHelper;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
public class Employee {
//    @Transient
//    EmployeeHelper employeeHelper = new EmployeeHelper();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Employee(String firstName, String lastName, LocalDate dob, String email, LocalDate startDate, EmployeeRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        //this.email = EmployeeHelper.generateEmail(firstName, lastName);
        this.email = email;
        this.startDate = startDate;
        this.role = role;
    }
}
