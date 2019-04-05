package com.example.ams.service;

import com.example.ams.model.Clazz;
import com.github.pagehelper.Page;

import java.util.List;

public interface ClazzService {
    public Page<Clazz> getAllClazz(Clazz clazz);
    public int addClazz(Clazz clazz);
    public int deleteClass(Integer id);
    public int editClass(Clazz clazz);
    public Clazz getClazzById(Integer id);
}
