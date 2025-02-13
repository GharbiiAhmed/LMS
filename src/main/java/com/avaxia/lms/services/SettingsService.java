package com.avaxia.lms.services;
import com.avaxia.lms.entities.Settings;
import com.avaxia.lms.entities.User;
import com.avaxia.lms.repositories.SettingsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SettingsService implements ISettingsService{
    @Autowired
    private SettingsRepository settingsRepository;

    @Override
    public Settings getSettingsByUserId(User user) {
        return settingsRepository.findByUserId(user);
    }

    @Override
    public Settings updateSettings(Settings settings) {
        return settingsRepository.save(settings);
    }

    @Override
    public void deleteSettings(Long settingsId) {
        settingsRepository.deleteById(settingsId);
    }
}