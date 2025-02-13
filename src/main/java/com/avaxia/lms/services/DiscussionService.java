package com.avaxia.lms.services;
import com.avaxia.lms.entities.Discussion;
import com.avaxia.lms.repositories.DiscussionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class DiscussionService implements IDiscussionService{
    @Autowired
    private DiscussionRepository discussionRepository;

    @Override
    public Discussion createDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public Discussion updateDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    @Override
    public void deleteDiscussion(Long discussionId) {
        discussionRepository.deleteById(discussionId);
    }

    @Override
    public List<Discussion> getDiscussionsByCourseId(Long courseId) {
        return discussionRepository.findByCourseId(courseId);
    }
}