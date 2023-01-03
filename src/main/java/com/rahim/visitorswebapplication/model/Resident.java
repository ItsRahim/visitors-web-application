package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//!TODO: Find a way to remove the need of the table mapping
@Data
@Entity
@Table(name = "residents")
@AllArgsConstructor
@NoArgsConstructor
public class Resident {
    @Id
    private String id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private LocalDate dob;

    private ResidentUnit unit;

    @Column(name = "funding_type")
    private String fundingType;
    private int band;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @OneToOne(mappedBy = "resident")
    private Booking booking;

    public Resident(String id, String firstName, String lastName, LocalDate dob, ResidentUnit unit, String fundingType, int band, LocalDate admissionDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.unit = unit;
        this.fundingType = fundingType;
        this.band = band;
        this.admissionDate = admissionDate;
    }
}