package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Assignment;
import com.avaxia.lms.services.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@AllArgsConstructor
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @PutMapping
    public Assignment updateAssignment(@RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(assignment);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Assignment> getAssignmentsByCourseId(@PathVariable Long courseId) {
        return assignmentService.getAssignmentsByCourseId(courseId);
    }
}