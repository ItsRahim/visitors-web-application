package com.rahim.visitorswebapplication.model;

import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "residents")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Resident {
    @Id
    @NonNull
    private String id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;


    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    private LocalDate dob;

    @NonNull
    private ResidentUnit unit;

    @NonNull
    @Column(name = "funding_type")
    private String fundingType;

    private int band;

    @NonNull
    @Column(name = "admission_date")
    private LocalDate admissionDate;


    @OneToOne(mappedBy = "resident")
    private Booking booking;
}