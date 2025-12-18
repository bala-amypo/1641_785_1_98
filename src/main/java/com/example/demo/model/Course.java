package com.example.demo.model;

import java.sql.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Course{
    @Id
    private Long id;
    private String title;
    private String description;
    private String instructor;
    private String category;
    private Date createdAt;
}