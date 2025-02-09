package com.avaxia.lms.services;

import com.avaxia.lms.entities.Assignment;
import com.avaxia.lms.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IAssignmentServiceImpl implements IAssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment getAssignment(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        Assignment existingAssignment = getAssignment(id);
        if (existingAssignment != null) {
            existingAssignment.setTitle(assignment.getTitle());
            existingAssignment.setDescription(assignment.getDescription());
            existingAssignment.setDueDate(assignment.getDueDate());
            existingAssignment.setCourse(assignment.getCourse()); // You may need to update the course
            return assignmentRepository.save(existingAssignment);
        }
        return null;
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
