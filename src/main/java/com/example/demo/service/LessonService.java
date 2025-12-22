package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MicroLesson;

public interface LessonService {
    MicroLesson post(MicroLesson ml);
    MicroLesson getLesson(Long lessonId);
    MicroLesson updateLesson(Long lessonId,MicroLesson lesson);
    List<MicroLesson> getall();
    String delemdata(Long id);
} 