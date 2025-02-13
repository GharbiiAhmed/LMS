package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress,Long> {
    UserProgress findByUserIdAndCourseId(Long userId, Long courseId); // To track user progress in a particular course

}
