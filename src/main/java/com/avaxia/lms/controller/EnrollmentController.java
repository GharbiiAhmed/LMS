package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Enrollment;
import com.avaxia.lms.services.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService IEnrollmentService;

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return IEnrollmentService.saveEnrollment(enrollment);
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return IEnrollmentService.getEnrollment(id);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return IEnrollmentService.getAllEnrollments();
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return IEnrollmentService.updateEnrollment(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        IEnrollmentService.deleteEnrollment(id);
    }
}
