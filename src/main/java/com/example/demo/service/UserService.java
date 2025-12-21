package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
        User register(User user);
        User findByid(Long id);
        List<User>getAll();
        String deldat(Long id);
        User updatadata(Long id,User u);
} 