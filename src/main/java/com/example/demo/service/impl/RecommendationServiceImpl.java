package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.MicroLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationServiceImpl implements com.example.demo.service.RecommendationService {
    
    @Autowired
    private RecommendationRepository recommendationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MicroLessonRepository microLessonRepository;
    
    @Override
    public Recommendation getLatestRecommendation(Long userId) {
        return recommendationRepository.findByUserIdOrderByGeneratedAtDesc(userId)
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No recommendations found"));
    }
}
