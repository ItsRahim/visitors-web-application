package com.rahim.visitorswebapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Visitor {
    @Id
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "visitor")
    @JsonIgnore
    private Set<Booking> booking;

    public Visitor(String firstName, String lastName, String email, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
