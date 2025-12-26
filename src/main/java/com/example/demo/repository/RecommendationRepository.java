package com.example.demo.repository;

import com.example.demo.model.Recommendation;  // ← CHANGED
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByUserIdOrderByGeneratedAtDesc(Long userId);
    
    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId AND r.generatedAt BETWEEN :start AND :end")
    List<Recommendation> findByUserIdAndGeneratedAtBetween(@Param("userId") Long userId,
                                                          @Param("start") LocalDateTime start,
                                                          @Param("end") LocalDateTime end);
}
