package com.avaxia.lms.services;
import com.avaxia.lms.entities.Announcement;
import com.avaxia.lms.repositories.AnnouncementRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class AnnouncementService implements IAnnouncementService{
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public void deleteAnnouncement(Long announcementId) {
        announcementRepository.deleteById(announcementId);
    }

    @Override
    public List<Announcement> getAnnouncementsByCourseId(Long courseId) {
        return announcementRepository.findByCourseId(courseId);
    }
}