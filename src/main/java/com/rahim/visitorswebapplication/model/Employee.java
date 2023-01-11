package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    public Employee(String firstName, String lastName, LocalDate dob, String email, LocalDate startDate, EmployeeRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.startDate = startDate;
        this.role = role;
    }
}
