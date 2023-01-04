package com.rahim.visitorswebapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Visitor {
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
    private String email;

    @NonNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "visitor")
    private Set<Booking> booking;
}
