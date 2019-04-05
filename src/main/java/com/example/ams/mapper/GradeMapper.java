package com.example.ams.mapper;

import com.example.ams.model.Grade;
import com.github.pagehelper.Page;

public interface GradeMapper {
    Page<Grade> selectAllGrade();
    int deleteByPrimaryKey(Integer id);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKeyWithBLOBs(Grade record);

    int updateByPrimaryKey(Grade record);
}