package com.avaxia.lms.services;

import com.avaxia.lms.entities.Submission;

import java.util.List;

public interface ISubmissionService {
    Submission saveSubmission(Submission submission);
    Submission getSubmission(Long id);
    List<Submission> getAllSubmissions();
    Submission updateSubmission(Long id, Submission submission);
    void deleteSubmission(Long id);
}
