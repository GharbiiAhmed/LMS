package com.avaxia.lms.services;

import com.avaxia.lms.entities.Enrollment;

import java.util.List;

public interface IEnrollmentService {

    Enrollment saveEnrollment(Enrollment enrollment);

    Enrollment getEnrollment(Long id);

    List<Enrollment> getAllEnrollments();

    Enrollment updateEnrollment(Long id, Enrollment enrollment);

    void deleteEnrollment(Long id);
}
