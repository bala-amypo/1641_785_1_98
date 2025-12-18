package com.example.demo.model;

import java.sql.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class MicroLesson{
    @Id
    private Long id;
    private Course course;
    private String title;
    private int durationMinutes;
    private String contentType;
    private String difficulty;
    private 
}