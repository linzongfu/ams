package com.example.ams.service.Impl;

import com.example.ams.mapper.SemesterMapper;
import com.example.ams.model.Semester;
import com.example.ams.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SemesterService")
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterMapper semesterMapper;

    @Override
    public List<Semester> getAllSemester(Semester semester) {
        return semesterMapper.getAllSemester(5);
    }

    @Override
    public int addSemester(Semester semester) {
        return semesterMapper.insert(semester);
    }

    @Override
    public int editSemester(Semester semester) {
        return semesterMapper.updateByPrimaryKey(semester);
    }

    @Override
    public int deleteSemester(Integer id) {
        return semesterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Semester getSemestetById(Integer id) {
        return semesterMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Semester> getSemesterByclassId(Integer id) {
        return null;
    }
}
