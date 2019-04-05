package com.example.ams.mapper;

import com.example.ams.model.Specialty;
import com.github.pagehelper.Page;

public interface SpecialtyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specialty record);

    int insertSelective(Specialty record);

    Specialty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specialty record);

    int updateByPrimaryKey(Specialty record);

    Page<Specialty> selectAllSpecialty(Specialty specialty);
}