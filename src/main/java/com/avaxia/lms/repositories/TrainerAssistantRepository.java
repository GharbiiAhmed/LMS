package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.TrainerAssistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerAssistantRepository extends JpaRepository<TrainerAssistant, Long> {
    //Optional<TrainerAssistant> findByEmail(String email);
    //boolean existsByEmail(String email);

    //List<TrainerAssistant> findByCourseId(Long idCourse); // Use courseId directly here

    @Query("SELECT ta FROM TrainerAssistant ta WHERE ta.course.id = :idCourse") // Use course.id here
    List<TrainerAssistant> findTrainerAssistantsByCourseId(@Param("idCourse") Long idCourse);
}
