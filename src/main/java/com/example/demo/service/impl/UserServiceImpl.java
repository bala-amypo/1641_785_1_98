package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository ur;

    @Override
    public User register(User u){
        return ur.save(u);
    }

    @Override
    public User findByid(Long id) {
        return ur.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
    }

    @Override
    public List<User> getAll() {
       return ur.findAll();
    }

    @Override
    public String deldat(Long id) {
        ur.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public User updatadata(Long id,User u) {
       if(ur.existsById(id)){
        u.setId(id);
        return ur.save(u);
       }
       return u;
    }
    
}
