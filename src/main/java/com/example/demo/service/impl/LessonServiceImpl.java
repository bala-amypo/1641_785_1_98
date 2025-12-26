package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements com.example.demo.service.LessonService {
    
    @Autowired
    private MicroLessonRepository microLessonRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        lesson.setCourse(course);
        return microLessonRepository.save(lesson);
    }
    
    @Override
    public MicroLesson updateLesson(Long id, MicroLesson lesson) {
        MicroLesson existing = microLessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        lesson.setId(id);
        lesson.setCourse(existing.getCourse());
        return microLessonRepository.save(lesson);
    }
    
    @Override
    public MicroLesson getLesson(Long id) {
        return microLessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }
    
    @Override
    public List<MicroLesson> findLessonsByFilters(String tags, MicroLesson.Difficulty difficulty, MicroLesson.ContentType contentType) {
        return microLessonRepository.findByFilters(tags, difficulty, contentType);
    }
}
