package com.avaxia.lms.services;

import com.avaxia.lms.entities.Content;
import java.util.List;

public interface IContentService {
    Content createContent(Content content);
    Content updateContent(Content content);
    void deleteContent(Long contentId);
    List<Content> getContentsByCourseId(Long courseId);
}
