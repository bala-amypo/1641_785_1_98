package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "micro_lessons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MicroLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @Column(name = "difficulty")
    private String difficulty = "BEGINNER";
    
    @Column(name = "content_type")
    private String contentType = "TEXT";
    
    @Column(name = "duration_minutes")
    private Integer durationMinutes = 5;
    
    private String tags;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (durationMinutes != null && durationMinutes > 15) {
            durationMinutes = 15;
        }
    }
}
