package com.rahim.visitorswebapplication.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ResidentUnit {
    WILLOW,
    ROSE,
    HAZEL;

    @Getter
    public String residentUnits;
}
