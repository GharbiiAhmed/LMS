package com.avaxia.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    List<Announcement> findByCourseId(Long courseId); // To get announcements for a specific course

}
