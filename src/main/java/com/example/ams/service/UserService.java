package com.example.ams.service;

import com.example.ams.model.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {
    public Page<User> getAllUser(User user);
    public List<User> getUserByClazz(Integer id);
    public  User findByNumber(String user);
    public User findByNumber(User user);

    public int editUser(User user);
    public int addUser(User user);
    public  int delete(int id);

}
