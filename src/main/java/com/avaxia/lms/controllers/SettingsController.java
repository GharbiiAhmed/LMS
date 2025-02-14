package com.avaxia.lms.controllers;

import com.avaxia.lms.entities.Settings;
import com.avaxia.lms.entities.User;
import com.avaxia.lms.services.SettingsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@AllArgsConstructor
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping("/user/{userId}")
    public Settings getSettingsByUserId(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return settingsService.getSettingsByUserId(user);
    }
    @PostMapping
    public Settings createSettings(@RequestBody Settings settings) {
        return settingsService.createSettings(settings);
    }
    @PutMapping
    public Settings updateSettings(@RequestBody Settings settings) {
        return settingsService.updateSettings(settings);
    }

    @DeleteMapping("/{id}")
    public void deleteSettings(@PathVariable Long id) {
        settingsService.deleteSettings(id);
    }
}