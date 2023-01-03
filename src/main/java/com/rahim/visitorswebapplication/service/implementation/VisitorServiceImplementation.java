package com.rahim.visitorswebapplication.service.implementation;

import com.rahim.visitorswebapplication.model.Employee;
import com.rahim.visitorswebapplication.model.Visitor;
import com.rahim.visitorswebapplication.repository.VisitorRepository;
import com.rahim.visitorswebapplication.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class VisitorServiceImplementation implements VisitorService {
    private final VisitorRepository visitorRepository;

    @Override
    @Transactional
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    @Transactional
    public Visitor updateVisitor(Visitor visitor, String id) {
        Visitor toUpdate = visitorRepository.findByIdOrError(id);
        toUpdate.setFirstName(visitor.getFirstName());
        toUpdate.setLastName(visitor.getLastName());
        toUpdate.setEmail(visitor.getEmail());
        toUpdate.setPhoneNumber(visitor.getPhoneNumber());
        return visitorRepository.save(toUpdate);
    }

    @Override
    @Transactional
    public void deleteVisitor(String id) {
        visitorRepository.deleteByVisitorId(id);
    }

    @Override
    public Visitor getVisitor(String id) {
        return visitorRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Visitor> listAll(int limit) {
        return visitorRepository.findAll(PageRequest.of(0, limit)).toList();
    }
}
