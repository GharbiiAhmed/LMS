package com.avaxia.lms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Learner extends User {

    // Learner-specific fields can go here, such as enrolled courses, grades, etc.
    @OneToMany(mappedBy = "learner", cascade = CascadeType.ALL)
    private List<Submission> submissions;
/*
    @OneToMany(mappedBy = "learner")
    private Set<Submission> submissions;
*/

}
