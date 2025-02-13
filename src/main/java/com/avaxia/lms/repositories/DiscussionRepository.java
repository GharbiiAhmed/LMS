package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
    List<Discussion> findByCourseId(Long courseId); // To get discussions by course ID

}
