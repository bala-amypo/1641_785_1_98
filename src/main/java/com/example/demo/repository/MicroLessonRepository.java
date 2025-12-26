package com.example.demo.repository;

import com.example.demo.model.MicroLesson;  // ← CHANGED
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MicroLessonRepository extends JpaRepository<MicroLesson, Long> {
    @Query("SELECT ml FROM MicroLesson ml WHERE " +
           "(:tags IS NULL OR ml.tags LIKE %:tags%) AND " +
           "(:difficulty IS NULL OR ml.difficulty = :difficulty) AND " +
           "(:contentType IS NULL OR ml.contentType = :contentType)")
    List<MicroLesson> findByFilters(@Param("tags") String tags,
                                   @Param("difficulty") MicroLesson.Difficulty difficulty,
                                   @Param("contentType") MicroLesson.ContentType contentType);
}
