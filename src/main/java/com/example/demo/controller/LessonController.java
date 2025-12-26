package com.example.demo.controller;

import com.example.demo.model.MicroLesson;
import com.example.demo.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    
    private final LessonService lessonService;
    
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }
    
    @PostMapping("/courses/{courseId}")
    public ResponseEntity<MicroLesson> addLesson(@PathVariable Long courseId, 
                                                @RequestBody MicroLesson lesson) {
        MicroLesson created = lessonService.addLesson(courseId, lesson);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MicroLesson> updateLesson(@PathVariable Long id, 
                                                   @RequestBody MicroLesson lesson) {
        MicroLesson updated = lessonService.updateLesson(id, lesson);
        return ResponseEntity.ok(updated);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MicroLesson> getLesson(@PathVariable Long id) {
        MicroLesson lesson = lessonService.getLesson(id);
        return ResponseEntity.ok(lesson);
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<MicroLesson>> findLessons(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String contentType) {
        List<MicroLesson> lessons = lessonService.findLessonsByFilters(tags, difficulty, contentType);
        return ResponseEntity.ok(lessons);
    }
}
