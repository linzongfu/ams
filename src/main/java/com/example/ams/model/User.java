package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String number;
    private String password;
    private  String name;
    private Integer type;
    private Integer status;
    private Integer class_id;
    private String remark;
    public List<StuAchievement> stuAchievement;
    private Date createAt;

}