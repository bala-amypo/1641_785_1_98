package com.example.demo.service.impl;

import com.example.demo.model.MicroLesson;
import com.example.demo.model.Progress;
import com.example.demo.model.User;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements com.example.demo.service.ProgressService {
    
    @Autowired
    private ProgressRepository progressRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MicroLessonRepository microLessonRepository;
    
    @Override
    public Progress recordProgress(Long userId, Long lessonId, Progress progress) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        MicroLesson lesson = microLessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        
        progress.setUser(user);
        progress.setMicroLesson(lesson);
        
        return progressRepository.findByUserIdAndMicroLessonId(userId, lessonId)
                .map(existing -> {
                    existing.setProgressPercent(progress.getProgressPercent());
                    existing.setStatus(progress.getStatus());
                    existing.setScore(progress.getScore());
                    return progressRepository.save(existing);
                })
                .orElseGet(() -> progressRepository.save(progress));
    }
    
    @Override
    public List<Progress> getUserProgress(Long userId) {
        return progressRepository.findByUserIdOrderByLastAccessedAtDesc(userId);
    }
}
