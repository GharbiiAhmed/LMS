package com.avaxia.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.Settings;
import com.avaxia.lms.entities.User;

public interface SettingsRepository extends JpaRepository<Settings,Long> {
    Settings findByUserId(User user); // To get settings for a specific user

}
