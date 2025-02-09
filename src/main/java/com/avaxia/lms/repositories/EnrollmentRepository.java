package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    Enrollment findByUserIdAndCourseId(Long userId, Long courseId);
}
