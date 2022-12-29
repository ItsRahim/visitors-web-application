package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Resident {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private LocalDate dob;

    private ResidentUnit unit;

    private String fundingType;
    private int band;
    private LocalDate admissionDate;

    @OneToOne(mappedBy = "resident")
    private Booking booking;
}