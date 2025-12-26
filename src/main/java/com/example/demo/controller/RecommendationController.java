package com.example.demo.controller;

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    
    @Autowired
    private RecommendationService recommendationService;
    
    @GetMapping("/latest/{userId}")
    public ResponseEntity<Recommendation> getLatestRecommendation(@PathVariable Long userId) {
        return ResponseEntity.ok(recommendationService.getLatestRecommendation(userId));
    }
}
