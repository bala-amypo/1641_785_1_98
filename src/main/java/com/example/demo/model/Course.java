package com.example.demo.model;

import java.sql.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Course{
    @Id
    private Long id;
    private String title;
    private String description;
    private String instructor; // Doubt  datatype-User
    private String category;
    private Date createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //Doubt  datatype-User
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    //Doubt
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Course(){}

    public Course(

    ){
        this.id=id;
        this.title=title;
        this.description=description;
        this.instructor=instructor;
        this.category=category;
        this.createdAt=createdAt;
    }

}