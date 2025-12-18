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
}