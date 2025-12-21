package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Progress;

public interface ProgressService {
    Progress postdata(Progress p);
    List<Progress> getdata();
    Progress getid(Long id);
    Progress updatedata(Long id,Progress p);
    String delProgress(Long id);
} 
