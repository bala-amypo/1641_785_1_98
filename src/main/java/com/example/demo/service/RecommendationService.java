package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Recommendation;



public interface RecommendationService {
    Recommendation rpostdata(Recommendation r);
    List<Recommendation> rgetdata();
    Recommendation rgetid(Long id);
    Recommendation rupdatedata(Long id,Recommendation r);
    String rdelProgress(Long id);
    
} 