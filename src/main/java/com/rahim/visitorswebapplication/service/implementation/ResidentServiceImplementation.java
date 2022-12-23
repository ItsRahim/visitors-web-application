package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.model.Resident;
import com.rahim.visitorswebapplication.repository.ResidentRepository;
import com.rahim.visitorswebapplication.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ResidentServiceImplementation implements ResidentService {

    private final ResidentRepository residentRepository;

    @Override
    public Resident createResident(Resident resident) {
        return residentRepository.save(resident);
    }

    @Override
    public Resident updateResident(Resident resident, String id) {
        Resident toUpdate = residentRepository.findById(id).orElse(null);
        toUpdate.setFirstName(resident.getFirstName());
        toUpdate.setLastName(resident.getLastName());
        toUpdate.setDob(resident.getDob());
        toUpdate.setUnit(resident.getUnit());
        toUpdate.setFundingType(resident.getFundingType());
        toUpdate.setBand(resident.getBand());
        toUpdate.setAdmissionDate(resident.getAdmissionDate());
        return residentRepository.save(toUpdate);
    }

    @Override
    public void deleteResident(String id) {
        residentRepository.deleteByResidentId(id);
    }

    @Override
    public Resident getResident(String id) {
        return residentRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Resident> listAll(int limit) {
        return residentRepository.findAll(PageRequest.of(0, limit)).toList();
    }
}
