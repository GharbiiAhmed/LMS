package com.avaxia.lms.controller;

import com.avaxia.lms.entities.Progression;
import com.avaxia.lms.services.IProgressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progressions")
public class ProgressionController {

    @Autowired
    private IProgressionService IProgressionService;

    @PostMapping
    public Progression createProgression(@RequestBody Progression progression) {
        return IProgressionService.saveProgression(progression);
    }

    @GetMapping("/{id}")
    public Progression getProgression(@PathVariable Long id) {
        return IProgressionService.getProgression(id);
    }

    @GetMapping
    public List<Progression> getAllProgressions() {
        return IProgressionService.getAllProgressions();
    }

    @PutMapping("/{id}")
    public Progression updateProgression(@PathVariable Long id, @RequestBody Progression progression) {
        return IProgressionService.updateProgression(id, progression);
    }

    @DeleteMapping("/{id}")
    public void deleteProgression(@PathVariable Long id) {
        IProgressionService.deleteProgression(id);
    }
}
