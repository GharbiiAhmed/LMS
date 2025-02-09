package com.avaxia.lms.services;

import com.avaxia.lms.entities.Progression;

import java.util.List;

public interface IProgressionService {
    Progression saveProgression(Progression progression);
    Progression getProgression(Long id);
    List<Progression> getAllProgressions();
    Progression updateProgression(Long id, Progression progression);
    void deleteProgression(Long id);
}
