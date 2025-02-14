package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Grade;
import com.avaxia.lms.services.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@AllArgsConstructor
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.createGrade(grade);
    }

    @PutMapping
    public Grade updateGrade(@RequestBody Grade grade) {
        return gradeService.updateGrade(grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<Grade> getGradesByAssignmentId(@PathVariable Long assignmentId) {
        return gradeService.getGradesByAssignmentId(assignmentId);
    }

    @GetMapping("/user/{userId}/course/{courseId}")
    public List<Grade> getGradesByUserIdAndCourseId(@PathVariable Long userId, @PathVariable Long courseId) {
        return gradeService.getGradesByUserIdAndCourseId(userId, courseId);
    }
}