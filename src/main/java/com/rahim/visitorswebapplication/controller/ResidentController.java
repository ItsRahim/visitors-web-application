package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.dto.ResidentDto;
import com.rahim.visitorswebapplication.dto.ResidentDto;
import com.rahim.visitorswebapplication.dto.ResidentDto;
import com.rahim.visitorswebapplication.model.Resident;
import com.rahim.visitorswebapplication.model.Resident;
import com.rahim.visitorswebapplication.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/resident")
@RequiredArgsConstructor
public class ResidentController {

    private final ResidentService residentService;
    private final ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<ResidentDto> listAll() {
        return residentService.listAll().stream()
                .map(Resident -> modelMapper.map(Resident, ResidentDto.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResidentDto getResident(@PathVariable Long id) {
        Resident resident = residentService.getResident(id);
        return modelMapper.map(resident, ResidentDto.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident create(@RequestBody Resident resident) {
        return residentService.createResident(resident);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public Resident updateResident(@RequestBody Resident resident, @PathVariable Long id) {
        return residentService.updateResident(resident, id);
    }
}
