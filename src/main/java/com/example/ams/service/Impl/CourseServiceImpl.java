package com.example.ams.service.Impl;

import com.example.ams.mapper.CourseMapper;
import com.example.ams.model.Course;
import com.example.ams.service.CourseService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public Page<Course> getAllCourse(Course course) {
        return courseMapper.selectAllCourse(course);
    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int editCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public int deleteCourse(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Course> getCourseBySemsterAndClass(Integer SemesterId, Integer ClassId) {
        return courseMapper.getCourseBySemsterAndClass(SemesterId,ClassId);
    }
}
