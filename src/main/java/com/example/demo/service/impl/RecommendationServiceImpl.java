package com.example.demo.service.impl;

import com.example.demo.model.Recommendation;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final MicroLessonRepository microLessonRepository;
    
    public RecommendationServiceImpl(RecommendationRepository recommendationRepository,
                                   UserRepository userRepository,
                                   MicroLessonRepository microLessonRepository) {
        this.recommendationRepository = recommendationRepository;
        this.userRepository = userRepository;
        this.microLessonRepository = microLessonRepository;
    }
    
    @Override
    public Recommendation getLatestRecommendation(Long userId) {
        List<Recommendation> recs = recommendationRepository.findByUserIdOrderByGeneratedAtDesc(userId);
        if (recs.isEmpty()) {
            throw new RuntimeException("No recommendations found");
        }
        return recs.get(0);
    }
}
