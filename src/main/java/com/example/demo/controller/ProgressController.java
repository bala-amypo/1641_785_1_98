package com.example.demo.controller;

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    
    private final ProgressService progressService;
    
    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }
    
    @PostMapping("/users/{userId}/lessons/{lessonId}")
    public ResponseEntity<Progress> recordProgress(@PathVariable Long userId, 
                                                  @PathVariable Long lessonId,
                                                  @RequestBody Progress progress) {
        Progress recorded = progressService.recordProgress(userId, lessonId, progress);
        return ResponseEntity.ok(recorded);
    }
    
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Progress>> getUserProgress(@PathVariable Long userId) {
        List<Progress> progressList = progressService.getUserProgress(userId);
        return ResponseEntity.ok(progressList);
    }
}
