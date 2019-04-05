package com.example.ams.service.Impl;

import com.example.ams.mapper.UserMapper;
import com.example.ams.model.User;
import com.example.ams.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("UserService")
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> getAllUser(User user) {
        return userMapper.selectAllUser(user);
    }

    @Override
    public List<User> getUserByClazz(Integer clazz_id) {
        return userMapper.getUserByClazz(clazz_id);
    }

    @Override
    public User findByNumber(String nunmber) {
        return userMapper.findByNumber(nunmber);
    }

    @Override
    public User findByNumber(User user) {
        return userMapper.findByNumber(user.getNumber());
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
