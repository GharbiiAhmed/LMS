package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Assignment;
import com.avaxia.lms.services.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private IAssignmentService IAssignmentService;

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return IAssignmentService.saveAssignment(assignment);
    }

    @GetMapping("/{id}")
    public Assignment getAssignment(@PathVariable Long id) {
        return IAssignmentService.getAssignment(id);
    }

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return IAssignmentService.getAllAssignments();
    }

    @PutMapping("/{id}")
    public Assignment updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        return IAssignmentService.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        IAssignmentService.deleteAssignment(id);
    }
}
