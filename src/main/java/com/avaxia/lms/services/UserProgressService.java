package com.avaxia.lms.services;
import com.avaxia.lms.entities.UserProgress;
import com.avaxia.lms.repositories.UserProgressRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserProgressService implements IUserProgressService{
    @Autowired
    private UserProgressRepository userProgressRepository;

    @Override
    public UserProgress createUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    @Override
    public UserProgress updateUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    @Override
    public void deleteUserProgress(Long userProgressId) {
        userProgressRepository.deleteById(userProgressId);
    }

    @Override
    public UserProgress getUserProgressByUserIdAndCourseId(Long userId, Long courseId) {
        return userProgressRepository.findByUserIdAndCourseId(userId, courseId);
    }
}