package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Resident;

import java.util.Collection;

public interface ResidentService {
    Resident createResident(Resident resident);
    Resident updateResident(Resident resident, String id);
    void deleteResident(String id);
    Resident getResident(String id);
    Collection<Resident> listAll(int limit);
}
