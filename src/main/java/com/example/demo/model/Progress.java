package com.example.demo.model;

import java.sql.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Progress{
    @Id
    private Long id;
    private User user; //datatype user
    private MicroLesson microLesson;
    private String status;
    private int progressPercent;
    private Date lastAccessedAt;
    private BigDecimal score;

    
}