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

import com.example.demo.model.Recommendation;
import com.example.demo.service.RecommendationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    @Autowired RecommendationService rs;
    @PostMapping("/post")
    public Recommendation postthedata(@Valid @RequestBody Recommendation r){
        return rs.rpostdata(r);
    }

    @GetMapping("/getall")
    public List<Recommendation> getallthedata(){
        return rs.rgetdata();
    }

    @GetMapping("/getid/{id}")
    public Recommendation gettheiddata(@PathVariable Long id){
        return rs.rgetid(id);
    }

    @PutMapping("/update/{id}")
    public Recommendation uProgress(@PathVariable Long id,@RequestBody Recommendation p ){
        return rs.rupdatedata(id, p);
    }

    @DeleteMapping("/del/{id}")
    public String dProgress(@PathVariable Long id){
        return rs.rdelProgress(id);
    }
}
