package com.example.ams.mapper;

import com.example.ams.model.Course;
import com.github.pagehelper.Page;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    Page<Course> selectAllCourse(Course course);

    List<Course> getCourseBySemsterAndClass(Integer semesterId, Integer classId);
}