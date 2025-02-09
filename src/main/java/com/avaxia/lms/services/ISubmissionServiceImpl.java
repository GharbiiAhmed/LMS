package com.avaxia.lms.services;

import com.avaxia.lms.entities.Submission;
import com.avaxia.lms.repositories.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ISubmissionServiceImpl implements ISubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public Submission saveSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public Submission getSubmission(Long id) {
        return submissionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public Submission updateSubmission(Long id, Submission submission) {
        Submission existingSubmission = getSubmission(id);
        if (existingSubmission != null) {
            existingSubmission.setFilePath(submission.getFilePath());
            existingSubmission.setSubmissionDate(submission.getSubmissionDate());
            existingSubmission.setAssignment(submission.getAssignment());
            return submissionRepository.save(existingSubmission);
        }
        return null;
    }

    @Override
    public void deleteSubmission(Long id) {
        submissionRepository.deleteById(id);
    }
}
