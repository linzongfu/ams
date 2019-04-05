package com.example.ams.mapper;

import com.example.ams.model.Semester;

import java.util.List;

public interface SemesterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Semester record);

    int insertSelective(Semester record);

    Semester selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKeyWithBLOBs(Semester record);

    int updateByPrimaryKey(Semester record);

    List<Semester> getAllSemester(Integer id);

    // List<Semester> getSemesterByClass(Integer id);
}