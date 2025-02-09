package com.avaxia.lms.services;

import com.avaxia.lms.entities.Assignment;

import java.util.List;

public interface IAssignmentService {
    Assignment saveAssignment(Assignment assignment);
    Assignment getAssignment(Long id);
    List<Assignment> getAllAssignments();
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
