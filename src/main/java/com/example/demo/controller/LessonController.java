package com.example.demo.controller;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    
    @Autowired
    private LessonService lessonService;
    
    @PostMapping("/course/{courseId}")
    public ResponseEntity<MicroLesson> addLesson(@PathVariable Long courseId, @RequestBody MicroLesson lesson) {
        return ResponseEntity.ok(lessonService.addLesson(courseId, lesson));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MicroLesson> getLesson(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getLesson(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MicroLesson> updateLesson(@PathVariable Long id, @RequestBody MicroLesson lesson) {
        return ResponseEntity.ok(lessonService.updateLesson(id, lesson));
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<MicroLesson>> findLessons(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) MicroLesson.Difficulty difficulty,
            @RequestParam(required = false) MicroLesson.ContentType contentType) {
        return ResponseEntity.ok(lessonService.findLessonsByFilters(tags, difficulty, contentType));
    }
}
