package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MicroLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;
    @NotBlank
    @Size(max=150)
    private String title;
    @NotBlank
    @Positive
    private int durationMinutes;
    @NotBlank
    private String contentType;
    @NotBlank
    @Size(max = 50)
    private String diffculty;
    @Size(max = 500)
    private String tags;
    @NotNull
    private LocalDate publishDate;
}
