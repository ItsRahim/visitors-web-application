package com.rahim.visitorswebapplication.service;

import com.rahim.visitorswebapplication.model.Visitor;

import java.util.Collection;

public interface VisitorService {
    Visitor createVisitor(Visitor employee);
    Visitor updateVisitor(Visitor employee, String id);
    void deleteVisitor(String id);
    Visitor getVisitor(String id);
    Collection<Visitor> listAll(int limit);
}
