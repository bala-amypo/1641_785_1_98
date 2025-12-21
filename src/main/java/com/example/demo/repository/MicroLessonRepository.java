package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.MicroLesson;


@Repository
public interface MicroLessonRepository extends JpaRepository<MicroLesson,Long>{

    
} 
