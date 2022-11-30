package com.rahim.visitorswebapplication.Entity;

import com.rahim.visitorswebapplication.Enum.EmployeeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(unique = true)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate dob;

    @Column(unique = true)
    private String email;
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;
}
