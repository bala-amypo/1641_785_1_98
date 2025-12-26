package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recommendations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "recommended_lesson_ids")
    private String recommendedLessonIds;
    
    @Column(name = "basis_snapshot")
    private String basisSnapshot;
    
    @Column(name = "confidence_score", precision = 3, scale = 2)
    private BigDecimal confidenceScore;
    
    @Column(name = "generated_at")
    private LocalDateTime generatedAt;
    
    @PrePersist
    public void prePersist() {
        this.generatedAt = LocalDateTime.now();
        if (confidenceScore != null) {
            double val = confidenceScore.doubleValue();
            confidenceScore = BigDecimal.valueOf(Math.max(0.0, Math.min(1.0, val)));
        }
    }
}
