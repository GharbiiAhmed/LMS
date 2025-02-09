package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.SubmissionDTO;
import com.avaxia.lms.entities.Submission;
import com.avaxia.lms.entities.Assignment;
import com.avaxia.lms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SubmissionMapperImpl {

    public SubmissionDTO fromSubmission(Submission submission) {
        if (submission == null) {
            return null;
        }

        SubmissionDTO submissionDTO = new SubmissionDTO();
        if (submission.getAssignment() != null) {
            submissionDTO.setAssignmentId(submission.getAssignment().getId());
        }
        if (submission.getUser() != null) {
            submissionDTO.setUserId(submission.getUser().getId());
        }

        BeanUtils.copyProperties(submission, submissionDTO);
        return submissionDTO;
    }

    public Submission fromSubmissionDTO(SubmissionDTO submissionDTO) {
        Submission submission = new Submission();
        Assignment assignment = new Assignment();
        assignment.setId(submissionDTO.getAssignmentId()); // assuming assignment id is provided
        submission.setAssignment(assignment);

        User user = new User();
        user.setId(submissionDTO.getUserId()); // assuming user id is provided
        submission.setUser(user);

        BeanUtils.copyProperties(submissionDTO, submission);
        return submission;
    }
}
