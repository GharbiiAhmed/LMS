package com.avaxia.lms.services;

import com.avaxia.lms.entities.Progression;
import com.avaxia.lms.repositories.ProgressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class IProgressionServiceImpl implements IProgressionService {

    @Autowired
    private ProgressionRepository progressionRepository;

    @Override
    public Progression saveProgression(Progression progression) {
        return progressionRepository.save(progression);
    }

    @Override
    public Progression getProgression(Long id) {
        return progressionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Progression> getAllProgressions() {
        return progressionRepository.findAll();
    }

    @Override
    public Progression updateProgression(Long id, Progression progression) {
        Progression existingProgression = getProgression(id);
        if (existingProgression != null) {
            existingProgression.setCompletedLessons(progression.getCompletedLessons()); // Correct method to update lessons
            return progressionRepository.save(existingProgression);
        }
        return null;
    }

    @Override
    public void deleteProgression(Long id) {
        progressionRepository.deleteById(id);
    }
}
