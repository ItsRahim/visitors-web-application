package com.rahim.visitorswebapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
//!TODO: Find a way to remove the need of the table mapping
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    @Id
    private String id;

//    @OneToMany(mappedBy = "visitor")
//    private Set<Booking> booking;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
