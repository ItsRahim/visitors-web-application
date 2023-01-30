package com.rahim.visitorswebapplication.dto;

import com.rahim.visitorswebapplication.enumeration.ResidentUnit;
import lombok.Data;

@Data
public class ResidentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private ResidentUnit unit;
    private int roomNumber;
}
