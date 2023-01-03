package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.model.Resident;
import com.rahim.visitorswebapplication.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2/resident")
@RequiredArgsConstructor
public class ResidentController {

    private final ResidentService residentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public Collection<Resident> listAll() {
        return residentService.listAll(10);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id}")
    public Resident getResident(@PathVariable String id) {
        return residentService.getResident(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Resident create(@RequestBody Resident resident) {
        return residentService.createResident(resident);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteResident(@PathVariable String id) {
        residentService.deleteResident(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}")
    public Resident updateResident(@RequestBody Resident resident, @PathVariable String id) {
        return residentService.updateResident(resident, id);
    }
}
