package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Resident;

import java.util.Collection;

public interface ResidentService {
    Resident createResident(Resident resident);
    Resident updateResident(Resident resident, Long id);
    void deleteResident(Long id);
    Resident getResident(Long id);
    Collection<Resident> listAll(int limit);
}
