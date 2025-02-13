package com.avaxia.lms.services;
import com.avaxia.lms.entities.Discussion;

import java.util.List;
public interface IDiscussionService {
    Discussion createDiscussion(Discussion discussion);
    Discussion updateDiscussion(Discussion discussion);
    void deleteDiscussion(Long discussionId);
    List<Discussion> getDiscussionsByCourseId(Long courseId);
}
