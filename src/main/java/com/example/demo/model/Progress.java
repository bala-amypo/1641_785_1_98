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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="progress")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Progress {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "micro_lesson_id",nullable = false)
    private MicroLesson microLesson;
    @NotBlank
    @Size(max = 20)
    private String status;
    @NotNull
    @Min(0)
    @Max(100)
    private int progressPercent;
    private LocalDateTime lastAccessedAt;
    @Column(precision = 5,scale = 2)
    private BigDecimal score;
    private LocalDateTime completedAt;

    @PrePersist
    public void Oncreate(){
        LocalDateTime n = LocalDateTime.now();
        if(this.lastAccessedAt==null){
            this.lastAccessedAt=n;
        }
        this.completedAt=n;
    }

    @PreUpdate
    public void Afterupdate(){
        LocalDateTime n = LocalDateTime.now();
        this.completedAt=n;
    }

    public Progress save(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
