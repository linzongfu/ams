package com.example.ams.service.Impl;

import com.example.ams.mapper.GradeMapper;
import com.example.ams.mapper.UserMapper;
import com.example.ams.model.Grade;
import com.example.ams.model.User;
import com.example.ams.service.GradeService;
import com.example.ams.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Page<Grade> getAllGrade() {
        return gradeMapper.selectAllGrade();
    }


    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.insert(grade);
    }

    @Override
    public int delete(int id) {
        return gradeMapper.deleteByPrimaryKey(id);
    }
}
