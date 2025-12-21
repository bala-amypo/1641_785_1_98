package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Recommendation;
import com.example.demo.repository.RecommendationRepository;
import com.example.demo.service.RecommendationService;


@Service
public class RecommendationServiceImpl implements RecommendationService  {
    @Autowired RecommendationRepository rr;

    @Override
    public Recommendation rpostdata(Recommendation r) {
        return rr.save(r);
    }

    @Override
    public List<Recommendation> rgetdata() {
        return rr.findAll();
    }

    @Override
    public Recommendation rgetid(Long id) {
        return rr.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
    }

    @Override
    public Recommendation rupdatedata(Long id, Recommendation r) {
        if(rr.existsById(id)){
            r.setId(id);
            return rr.save(r);
        }
        throw new ResourceNotFoundException("Not found");
    }

    @Override
    public String rdelProgress(Long id) {
        rr.deleteById(id);
        return "Deleted Successfully";
    }

}
