package com.avaxia.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    List<Assignment> findByCourseId(Long courseId); // To get assignments for a specific course

}
