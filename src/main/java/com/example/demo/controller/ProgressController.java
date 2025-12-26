package com.example.demo.controller;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    
    @Autowired
    private ProgressService progressService;
    
    @PostMapping("/{userId}/{lessonId}")
    public ResponseEntity<Progress> recordProgress(@PathVariable Long userId, @PathVariable Long lessonId, 
                                                  @RequestBody Progress progress) {
        return ResponseEntity.ok(progressService.recordProgress(userId, lessonId, progress));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getUserProgress(@PathVariable Long userId) {
        return ResponseEntity.ok(progressService.getUserProgress(userId));
    }
}
