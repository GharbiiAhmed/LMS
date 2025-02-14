package com.avaxia.lms.services;
import com.avaxia.lms.entities.Settings;
import com.avaxia.lms.entities.User;

public interface ISettingsService {
    Settings getSettingsByUserId(User user);
    Settings updateSettings(Settings settings);
    public Settings createSettings(Settings settings);
    void deleteSettings(Long settingsId);
}
