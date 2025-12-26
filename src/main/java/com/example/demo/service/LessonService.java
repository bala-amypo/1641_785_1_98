package com.example.demo.service;

import com.example.demo.model.MicroLesson;
import java.util.List;

public interface LessonService {
    MicroLesson addLesson(Long courseId, MicroLesson lesson);
    MicroLesson updateLesson(Long id, MicroLesson lesson);
    MicroLesson getLesson(Long id);
    List<MicroLesson> findLessonsByFilters(String tags, MicroLesson.Difficulty difficulty, MicroLesson.ContentType contentType);
}
