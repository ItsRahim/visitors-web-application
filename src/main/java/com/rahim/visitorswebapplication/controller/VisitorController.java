package com.rahim.visitorswebapplication.controller;

import com.rahim.visitorswebapplication.model.Visitor;
import com.rahim.visitorswebapplication.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/v2/visitor")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorService visitorService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Collection<Visitor> listAll() {
        return visitorService.listAll(10);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable String id) {
        return visitorService.getVisitor(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Visitor create(@RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable String id) {
        visitorService.deleteVisitor(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Visitor updateVisitor(@RequestBody Visitor visitor, @PathVariable String id) {
        return visitorService.updateVisitor(visitor, id);
    }

}
