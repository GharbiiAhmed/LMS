package com.avaxia.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.Activity;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Long> {
    List<Activity> findByCourseId(Long courseId); // To get tasks or activities for a course
    List<Activity> findByUserId(Long userId); // Add this method to find events by userId
}
