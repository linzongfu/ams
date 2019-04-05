package com.example.ams.service;

import com.example.ams.model.User;
import com.example.ams.model.clazzCourse;
import com.github.pagehelper.Page;

public interface ClazzCourseService {
   /*
    public Page<User> getAllUser(User user);
    public  User findByNumber(String user);
    public User findByNumber(User user);

    public int editUser(User user);
    public int addUser(User user);
    public  int delete(int id);
    */
   public clazzCourse getCCbyoptin(Integer classId,Integer courseId,Integer semesterId);

}
