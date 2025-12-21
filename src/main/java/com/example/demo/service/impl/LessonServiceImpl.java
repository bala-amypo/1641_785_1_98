package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.MicroLesson;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired MicroLessonRepository mr;

    @Override
    public MicroLesson post(MicroLesson ml) {
        return mr.save(ml);
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return mr.findById(lessonId).orElseThrow(()->new ResourceNotFoundException("Not found"));
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {
        if(mr.existsById(lessonId)){
            lesson.setId(lessonId);
            return mr.save(lesson);
        }
        throw new ResourceNotFoundException("Not found");
    }

    @Override
    public List<MicroLesson> getall() {
        return mr.findAll();
    }

    @Override
    public String delemdata(Long id) {
        if(mr.existsById(id)){
            mr.deleteById(id);
            return "Deleted successfully";
        }
        return "No data in that id";
    }

    
}
