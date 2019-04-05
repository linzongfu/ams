package com.example.ams.mapper;

import com.example.ams.model.clazzCourse;

public interface clazzCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(clazzCourse record);

    int insertSelective(clazzCourse record);

    clazzCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(clazzCourse record);

    int updateByPrimaryKeyWithBLOBs(clazzCourse record);

    int updateByPrimaryKey(clazzCourse record);

    clazzCourse getCCByoption(Integer classId, Integer courseId, Integer semesterId);
}