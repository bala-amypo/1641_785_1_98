package com.example.demo.model;

import java.sql.Data;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Recommendation{
    @Id
    private Long id;
    private User user; // Doubt (datatype)
    private Date generatedAt;
    private String recommendedLessonIds;
    private String basisSnapshot;
    private BigDecimal confidenceScore;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Date getGeneratedAt() {
        return generatedAt;
    }
    public void setGeneratedAt(Date generatedAt) {
        this.generatedAt = generatedAt;
    }
    public String getRecommendedLessonIds() {
        return recommendedLessonIds;
    }
    public void setRecommendedLessonIds(String recommendedLessonIds) {
        this.recommendedLessonIds = recommendedLessonIds;
    }
    public String getBasisSnapshot() {
        return basisSnapshot;
    }
    public void setBasisSnapshot(String basisSnapshot) {
        this.basisSnapshot = basisSnapshot;
    }
    public BigDecimal getConfidenceScore() {
        return confidenceScore;
    }
    public void setConfidenceScore(BigDecimal confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

}