package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.dto.VisitorDto;
import com.rahim.visitorswebapplication.model.Visitor;
import com.rahim.visitorswebapplication.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v2/visitor")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService visitorService;
    private final ModelMapper modelMapper;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Collection<VisitorDto> listAll() {
        return visitorService.listAll().stream()
                .map(Visitor -> modelMapper.map(Visitor, VisitorDto.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public VisitorDto getVisitor(@PathVariable Long id) {
        Visitor visitor = visitorService.getVisitor(id);
        return modelMapper.map(visitor, VisitorDto.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Visitor create(@RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Visitor updateVisitor(@RequestBody Visitor visitor, @PathVariable Long id) {
        return visitorService.updateVisitor(visitor, id);
    }

}
