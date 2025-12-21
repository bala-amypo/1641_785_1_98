package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation,Long>{

    
} 
