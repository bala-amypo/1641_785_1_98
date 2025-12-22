package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseService {
    Course post(Course c);
    Course updateCourse(Long courseId,Course course);
    Course getCourse(Long courseId);
    List<Course> getall();
} 