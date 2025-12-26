package com.example.demo.service;

import com.example.demo.model.Course;

public interface CourseService {
    Course createCourse(Course course, Long instructorId);
    Course updateCourse(Long id, Course course);
    Course getCourse(Long id);
}
