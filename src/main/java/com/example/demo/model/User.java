package com.example.demo.model;

import java.sql.Data;
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String preferredLearningStyle;
    private Date createdAt;

    public void setId(Long id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setPreferredLearningStyle(String preferredLearningStyle) {
        this.preferredLearningStyle = preferredLearningStyle;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public String getPreferredLearningStyle() {
        return preferredLearningStyle;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
}
