package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Progress;
import com.example.demo.repository.ProgressRepository;
import com.example.demo.service.ProgressService;

import jakarta.validation.Valid;

@Service
public class ProgressServiceImpl implements ProgressService{
    @Autowired ProgressRepository pr;
    @Override
    public Progress postdata(@Valid Progress p) {
        return pr.save(p);
    }
    @Override
    public List<Progress> getdata() {
        return pr.findAll();
    }
    @Override
    public Progress getid(Long id) {
        return pr.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
    }
    @Override
    public Progress updatedata(Long id, Progress p) {
        if(pr.existsById(id)){
            p.setId(id);
            return pr.save(p);
        }
        throw new ResourceNotFoundException("Not found");
    }
    @Override
    public String delProgress(Long id){
        pr.deleteById(id);
        return "Deleted Successfully";
    }
    
    
    
}
