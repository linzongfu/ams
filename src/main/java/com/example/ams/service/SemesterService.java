package com.example.ams.service;

import com.example.ams.model.Semester;

import java.util.List;

public interface SemesterService {
    public List<Semester> getAllSemester(Semester semester);
    public int addSemester(Semester semester);
    public int editSemester(Semester semester);
    public int deleteSemester(Integer id);
    public Semester getSemestetById(Integer id);
    public List<Semester> getSemesterByclassId(Integer id);
}
