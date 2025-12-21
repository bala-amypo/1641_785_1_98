package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max=150)
    private String title;
    @Size(max=500)
    private String description;
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable=false)
    private User instructor;
    @NotBlank
    @Size(max=50)
    private String category;
    private LocalDateTime createdAt;

    @PrePersist
    public void Oncreate(){
        LocalDateTime n = LocalDateTime.now();
        if(this.createdAt==null){
            this.createdAt=n;
        }
    }

}



