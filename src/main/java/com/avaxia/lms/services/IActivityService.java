package com.avaxia.lms.services;
import com.avaxia.lms.entities.Activity;

import java.util.List;
public interface IActivityService {
    Activity createActivity(Activity activity);
    Activity updateActivity(Activity activity);
    void deleteActivity(Long activityId);
    List<Activity> getActivitiesByCourseId(Long courseId);
    List<Activity> getActivitiesByUserId(Long userId);
}
