package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Visitor;

import java.util.Collection;

public interface VisitorService {
    Visitor createVisitor(Visitor employee);
    Visitor updateVisitor(Visitor employee, Long id);
    void deleteVisitor(Long id);
    Visitor getVisitor(Long id);
    Collection<Visitor> listAll(int limit);
}
