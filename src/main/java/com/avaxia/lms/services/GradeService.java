package com.avaxia.lms.services;
import com.avaxia.lms.entities.Grade;
import com.avaxia.lms.repositories.GradeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class GradeService implements IGradeService{
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public List<Grade> getGradesByAssignmentId(Long assignmentId) {
        return gradeRepository.findByAssignmentId(assignmentId);
    }

    @Override
    public List<Grade> getGradesByUserIdAndCourseId(Long userId, Long courseId) {
        return gradeRepository.findByUserIdAndCourseId(userId, courseId);
    }
}