package com.rahim.visitorswebapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "residents")
@NoArgsConstructor
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private LocalDate dob;

    private ResidentUnit unit;

    private int roomNumber;

    @Column(name = "funding_type")
    private String fundingType;

    private int band;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @OneToMany(mappedBy = "resident")
    @JsonIgnore
    private Set<Booking> booking;

    public Resident(String firstName, String lastName, LocalDate dob, ResidentUnit unit, int roomNumber, String fundingType, int band, LocalDate admissionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.unit = unit;
        this.roomNumber = roomNumber;
        this.fundingType = fundingType;
        this.band = band;
        this.admissionDate = admissionDate;
    }
}