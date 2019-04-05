package com.example.ams.service.Impl;

import com.example.ams.mapper.SpecialtyMapper;
import com.example.ams.model.Specialty;
import com.example.ams.service.SpecialtyService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SpecialtyService")
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Override
    public Page<Specialty> getAllSpecialty(Specialty specialty) {
        return specialtyMapper.selectAllSpecialty(specialty);
    }

    @Override
    public int editSpecialty(Specialty specialty) {
        return specialtyMapper.updateByPrimaryKey(specialty);
    }

    @Override
    public int deleteSpecialty(Integer id) {
        return specialtyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addSpecialty(Specialty specialty) {
        return specialtyMapper.insert(specialty);
    }
}
