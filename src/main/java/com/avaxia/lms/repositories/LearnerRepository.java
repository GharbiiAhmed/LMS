package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
    //Optional<Learner> findByEmail(String email);
    //boolean existsByEmail(String email);
}
