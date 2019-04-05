package com.example.ams.service.Impl;

import com.example.ams.mapper.clazzCourseMapper;
import com.example.ams.model.clazzCourse;
import com.example.ams.service.ClazzCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ClazzCourseService")
public class ClazzCourseServiceImpl implements ClazzCourseService {

    @Autowired
    clazzCourseMapper clazzCourseMapper;

    @Override
    public clazzCourse getCCbyoptin(Integer classId, Integer courseId, Integer semesterId) {
        return clazzCourseMapper.getCCByoption(classId, courseId, semesterId);
    }
}
