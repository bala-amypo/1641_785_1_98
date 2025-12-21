package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="recommendations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    private LocalDateTime generatedAt;
    @NotBlank
    @Size(max=1000)
    private String recommendedLessonIds;
    @Size(max = 2000)
    private String basisSnapshot;
    @NotNull
    @DecimalMax("1.0")
    @DecimalMin("0.0")
    @Column(precision = 3,scale = 2)
    private BigDecimal confidenceScore;

    @PrePersist
     public void Oncreate(){
        LocalDateTime n = LocalDateTime.now();
        if(this.generatedAt==null){
            this.generatedAt=n;
        }
    }
}
