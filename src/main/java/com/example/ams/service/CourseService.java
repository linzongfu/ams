package com.example.ams.service;


import com.example.ams.model.Course;
import com.example.ams.model.Semester;
import com.github.pagehelper.Page;

import java.util.List;

public interface CourseService {
    public Page<Course> getAllCourse(Course course);
    public int addCourse(Course course);
    public int editCourse(Course course);
    public int deleteCourse(Integer id);

    List<Course> getCourseBySemsterAndClass(Integer SemesterId, Integer ClassId);
}
