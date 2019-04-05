package com.example.ams.service;

import com.example.ams.model.Specialty;
import com.github.pagehelper.Page;

import java.util.List;

public interface SpecialtyService {
    public Page<Specialty> getAllSpecialty(Specialty specialty);
    public int editSpecialty(Specialty specialty);
    public int deleteSpecialty(Integer id);
    public int addSpecialty(Specialty specialty);
}
