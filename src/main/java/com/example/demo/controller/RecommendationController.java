package com.example.demo.controller;

import com.example.demo.dto.RecommendationRequest;
import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    
    private final RecommendationService recommendationService;
    
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }
    
    @PostMapping("/latest")
    public ResponseEntity<Recommendation> getLatestRecommendation(@RequestBody RecommendationRequest request) {
        Recommendation recommendation = recommendationService.getLatestRecommendation(request.getUserId());
        return ResponseEntity.ok(recommendation);
    }
}
