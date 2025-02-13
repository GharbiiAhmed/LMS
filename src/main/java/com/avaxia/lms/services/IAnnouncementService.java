package com.avaxia.lms.services;
import com.avaxia.lms.entities.Announcement;

import java.util.List;
public interface IAnnouncementService {
    Announcement createAnnouncement(Announcement announcement);
    Announcement updateAnnouncement(Announcement announcement);
    void deleteAnnouncement(Long announcementId);
    List<Announcement> getAnnouncementsByCourseId(Long courseId);
}
