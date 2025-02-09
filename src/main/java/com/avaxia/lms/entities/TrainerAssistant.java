package com.avaxia.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrainerAssistant extends User {

    // Trainer Assistant-specific fields can go here, like helping with assessments, grading, etc.
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer; // Assigns a Trainer to the assistant

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course; // Ensure this is added
}
