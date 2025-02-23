package com.avaxia.lms.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private User user;

}