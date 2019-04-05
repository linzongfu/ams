package com.example.ams.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuAchievement {
    private String CourseName;
    private String SemesterName;
    private Double Score;
    private Double MaxScore;
    private Double MinScore;
    private Double AvgScore;
    private Double FailNumber;
}
