package com.avaxia.lms.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean notificationsEnabled;
    private String themePreference;
    @ManyToOne
    @JoinColumn(name = "user_id") // The column in your database that links Settings to User
    private User user;
    // Getters and Setters
}