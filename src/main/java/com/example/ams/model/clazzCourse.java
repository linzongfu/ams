package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class clazzCourse {
    private Integer id;

    private Integer classid;

    private Integer courseid;

    private Integer semesterid;

    private String teacherid;

    private String remark;
    }