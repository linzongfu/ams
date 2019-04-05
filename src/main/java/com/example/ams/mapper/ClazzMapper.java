package com.example.ams.mapper;

import com.example.ams.model.Clazz;
import com.github.pagehelper.Page;

import java.util.List;

public interface ClazzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clazz record);

    int insertSelective(Clazz record);

    Clazz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clazz record);

    int updateByPrimaryKey(Clazz record);

    Page<Clazz> getAllClass(Clazz clazz);
}