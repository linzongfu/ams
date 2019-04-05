package com.example.ams.service;

import com.example.ams.model.Grade;
import com.github.pagehelper.Page;

public interface GradeService {
    public Page<Grade> getAllGrade();
    public int addGrade(Grade Grade);
    public  int delete(int id);
}
