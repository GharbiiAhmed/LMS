package com.avaxia.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade,Long> {
    List<Grade> findByAssignmentId(Long assignmentId); // To get grades for a specific assignment
    List<Grade> findByUserIdAndCourseId(Long userId, Long courseId); // To get a user's grade in a particular course
}
