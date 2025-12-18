package com.example.demo.model;

import java.sql.Data;
import java.math.BigDecimal;
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public MicroLesson getMicroLesson() {
        return microLesson;
    }
    public void setMicroLesson(MicroLesson microLesson) {
        this.microLesson = microLesson;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getProgressPercent() {
        return progressPercent;
    }
    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }
    public Date getLastAccessedAt() {
        return lastAccessedAt;
    }
    public void setLastAccessedAt(Date lastAccessedAt) {
        this.lastAccessedAt = lastAccessedAt;
    }
    public BigDecimal getScore() {
        return score;
    }
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Progress(){}

    public Progress(
        Long id,User user,MicroLesson microLesson,String status, int progressPercent,Date lastAccessedAt,BigDecimal score
    ){
        this.id=id;
        this.
    }

}