package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired LessonService ls;
    @PostMapping("/post")
    public MicroLesson postall(@Valid MicroLesson ml){
        return ls.post(ml);
    }

    @GetMapping("/search/{search}")
    public MicroLesson getbyID(@PathVariable("search") Long id){
        return ls.getLesson(id);
    }

    @PutMapping("/{lessonId}")
    public MicroLesson update(@PathVariable("lessonId") Long id,MicroLesson ml){
        return ls.updateLesson(id, ml);
    }

    @GetMapping("/getall")
    public List<MicroLesson> getAll(){
        return ls.getall();
    }

    @DeleteMapping("/dele/{id}")
    public String delete(@PathVariable Long id){
        return ls.delemdata(id);
    }

}
