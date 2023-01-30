package com.rahim.visitorswebapplication.dto;

import lombok.Data;

@Data
public class VisitorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
