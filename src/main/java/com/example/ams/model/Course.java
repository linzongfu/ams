package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String no;
    private String name;
    private Date createAt;
    private String teacher;
  }