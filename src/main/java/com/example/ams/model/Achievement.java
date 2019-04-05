package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Achievement {
    private Integer id;
    private String studentid;
    private Integer ccid;
    private Double score;
    private Date createAt;
    private int courseId;
    private int semesterId;
    private String remark;
}