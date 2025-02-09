package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Progression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionRepository extends JpaRepository<Progression,Long> {
}
