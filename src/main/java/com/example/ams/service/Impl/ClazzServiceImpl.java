package com.example.ams.service.Impl;

import com.example.ams.mapper.ClazzMapper;
import com.example.ams.model.Clazz;
import com.example.ams.service.ClazzService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClazzService")
public class ClazzServiceImpl implements ClazzService {

    @Autowired
     ClazzMapper clazzMapper;

    @Override
    public Page<Clazz> getAllClazz(Clazz clazz) {
        return clazzMapper.getAllClass(clazz);
    }

    @Override
    public int addClazz(Clazz clazz) {
        return clazzMapper.insert(clazz);
    }

    @Override
    public int deleteClass(Integer id) {
        return clazzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int editClass(Clazz clazz) {
        return clazzMapper.updateByPrimaryKey(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.selectByPrimaryKey(id);
    }
}
