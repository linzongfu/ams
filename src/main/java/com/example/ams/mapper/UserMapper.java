package com.example.ams.mapper;

import com.example.ams.model.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Page<User> selectAllUser(User user);

    User findByNumber(String number);

    List<User> getUserByClazz(Integer clazz_id);
}