package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private Integer specialtyId;
    private Integer gradeId;
    private String speName;
    private  String graName;
    private  String teaName;
    private Integer semesterId;
    private String teacherId;
    private String createAt;
}