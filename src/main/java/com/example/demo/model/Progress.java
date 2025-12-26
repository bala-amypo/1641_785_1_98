package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "progress")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "micro_lesson_id")
    private MicroLesson microLesson;
    
    @Column(name = "progress_percent")
    private Integer progressPercent = 0;
    
    private String status = "IN_PROGRESS";
    
    private BigDecimal score;
    
    @Column(name = "last_accessed_at")
    private LocalDateTime lastAccessedAt;
    
    @PrePersist
    public void prePersist() {
        this.lastAccessedAt = LocalDateTime.now();
        if ("COMPLETED".equals(status)) {
            this.progressPercent = 100;
        }
    }
    
    @PreUpdate
    public void preUpdate() {
        this.lastAccessedAt = LocalDateTime.now();
    }
}
