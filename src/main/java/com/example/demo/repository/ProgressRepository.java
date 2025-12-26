package com.example.demo.repository;

import com.example.demo.model.Progress;  // ← CHANGED
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUserIdAndMicroLessonId(Long userId, Long microLessonId);
    
    @Query("SELECT p FROM Progress p WHERE p.user.id = :userId ORDER BY p.lastAccessedAt DESC")
    List<Progress> findByUserIdOrderByLastAccessedAtDesc(@Param("userId") Long userId);
}
