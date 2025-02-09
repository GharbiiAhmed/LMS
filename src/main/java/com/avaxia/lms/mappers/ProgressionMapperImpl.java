package com.avaxia.lms.mappers;

import com.avaxia.lms.dtos.ProgressionDTO;
import com.avaxia.lms.entities.Progression;
import com.avaxia.lms.entities.Course;
import com.avaxia.lms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProgressionMapperImpl {

    public ProgressionDTO fromProgression(Progression progression) {
        if (progression == null) {
            return null;
        }

        ProgressionDTO progressionDTO = new ProgressionDTO();
        if (progression.getLearner() != null) {
            progressionDTO.setLearnerId(progression.getLearner().getId());
        }
        if (progression.getCourse() != null) {
            progressionDTO.setCourseId(progression.getCourse().getId());
        }

        BeanUtils.copyProperties(progression, progressionDTO);
        return progressionDTO;
    }

    public Progression fromProgressionDTO(ProgressionDTO progressionDTO) {
        Progression progression = new Progression();
        User learner = new User();
        learner.setId(progressionDTO.getLearnerId()); // assuming learner id is provided
        progression.setLearner(learner);

        Course course = new Course();
        course.setId(progressionDTO.getCourseId()); // assuming course id is provided
        progression.setCourse(course);

        BeanUtils.copyProperties(progressionDTO, progression);
        return progression;
    }
}
