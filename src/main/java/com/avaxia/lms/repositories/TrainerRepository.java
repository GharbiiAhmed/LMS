package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    //Optional<Trainer> findByEmail(String email);
    //boolean existsByEmail(String email);

    //List<Trainer> findByCourseId(Long idCourse); // Use courseId directly here

    //@Query("SELECT t FROM Trainer t WHERE t.course.id = :idCourse") // Use course.id here
    //List<Trainer> findTrainersByCourseId(@Param("idCourse") Long idCourse);
}
