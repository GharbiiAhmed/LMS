package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
    Optional<Course> findByName(String name);
    List<Course> findByTrainerId(Long trainerId);
    List<Course> findByTrainerAssistantId(Long trainerAssistantId);
    boolean existsByName(String name);
}
