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

import com.example.demo.model.Progress;
import com.example.demo.service.ProgressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired ProgressService ps;
    @PostMapping("/post")
    public Progress postthedata(@Valid @RequestBody Progress p){
        return ps.postdata(p);
    }

    @GetMapping("/getall")
    public List<Progress> getallthedata(){
        return ps.getdata();
    }

    @GetMapping("/getid/{id}")
    public Progress gettheiddata(@PathVariable Long id){
        return ps.getid(id);
    }

    @PutMapping("/update/{id}")
    public Progress uProgress(@PathVariable Long id,@RequestBody Progress p ){
        return ps.updatedata(id, p);
    }

    @DeleteMapping("/del/{id}")
    public String dProgress(@PathVariable Long id){
        return ps.delProgress(id);
    }
}
