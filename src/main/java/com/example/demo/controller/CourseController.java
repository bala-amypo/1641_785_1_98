package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired CourseService c;
    @PostMapping("/")
    public Course cpost(@Valid @RequestBody Course co){
        return c.post(co);
    }
    @PutMapping("/{courseId}")
    public Course getupdate(@PathVariable("courseId") Long id,@RequestBody Course co){
        return c.updateCourse(id,co);
    }
    @GetMapping("/courseId/{courseId}")
    public Course GetCourse(@PathVariable("courseId") Long id){
        return c.getCourse(id);
    }

    @GetMapping("alldata")
    public List<Course> allcget(){
        return c.getall();
    }
}
