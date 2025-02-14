package com.avaxia.lms.services;

import com.avaxia.lms.entities.Content;
import com.avaxia.lms.repositories.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContentService implements IContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content updateContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public void deleteContent(Long contentId) {
        contentRepository.deleteById(contentId);
    }

    @Override
    public List<Content> getContentsByCourseId(Long courseId) {
        return contentRepository.findByCourseId(courseId);
    }
}
