package com.avaxia.lms.services;
import com.avaxia.lms.entities.UserProgress;

public interface IUserProgressService {
    UserProgress createUserProgress(UserProgress userProgress);
    UserProgress updateUserProgress(UserProgress userProgress);
    void deleteUserProgress(Long userProgressId);
    UserProgress getUserProgressByUserIdAndCourseId(Long userId, Long courseId);
}
