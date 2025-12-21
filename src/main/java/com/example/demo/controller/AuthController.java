package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired UserService us;
    @PostMapping("/register")
    public User uregister(@Valid @RequestBody User u){
        return us.register(u);
    }

    @GetMapping("/getid/{id}")
    public User getid(@PathVariable Long id){
        return us.findByid(id);
    }

    @GetMapping("/alldata")
    public List<User> getalldata(){
        return us.getAll();
    }

    @DeleteMapping("/dele")
    public String del(@PathVariable Long id){
        return us.deldat(id);
    }

    @PutMapping("/update/{id}")
    public User up(@PathVariable Long id,@RequestBody User u){
        return us.updatadata(id, u);
    }
}
