package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Submission;
import com.avaxia.lms.services.ISubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private ISubmissionService ISubmissionService;

    @PostMapping
    public Submission createSubmission(@RequestBody Submission submission) {
        return ISubmissionService.saveSubmission(submission);
    }

    @GetMapping("/{id}")
    public Submission getSubmission(@PathVariable Long id) {
        return ISubmissionService.getSubmission(id);
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return ISubmissionService.getAllSubmissions();
    }

    @PutMapping("/{id}")
    public Submission updateSubmission(@PathVariable Long id, @RequestBody Submission submission) {
        return ISubmissionService.updateSubmission(id, submission);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmission(@PathVariable Long id) {
        ISubmissionService.deleteSubmission(id);
    }
}
