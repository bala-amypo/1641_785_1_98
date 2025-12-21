package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired CourseRepository cr;
    @Override
    public Course updateCourse(Long courseId, Course course) {
        if(cr.existsById(courseId)){
        course.setId(courseId);
        return cr.save(course);
       }
       throw new ResourceNotFoundException("Not found");
    }
    @Override
    public Course getCourse(Long id){
        return cr.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
    } 
    @Override 
    public Course post(Course c){
        return cr.save(c);
    }

    @Override
    public List<Course> getall(){
        return cr.findAll();
    }
    
}
