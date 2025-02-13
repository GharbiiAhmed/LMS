package com.avaxia.lms.services;
import com.avaxia.lms.entities.Grade;

import java.util.List;
public interface IGradeService {
    Grade createGrade(Grade grade);
    Grade updateGrade(Grade grade);
    void deleteGrade(Long gradeId);
    List<Grade> getGradesByAssignmentId(Long assignmentId);
    List<Grade> getGradesByUserIdAndCourseId(Long userId, Long courseId);
}
