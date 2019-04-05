package com.example.ams.service;

import com.example.ams.model.Achievement;
import com.example.ams.model.StuAchievement;
import com.github.pagehelper.Page;

import java.util.List;

public interface AchievementService {
    public Page<Achievement> getAllAchievement(Achievement achievement);
    public int addAchievement(Achievement achievement);
    public int deleteAchievement(Integer id);
    public int editAchievement(Achievement achievement);
    public Achievement getAchievementById(Integer id);
    public List<Achievement> exitAchivement(String number, int ccid);
    public List<StuAchievement>  usualPerformance(String number,Integer semesterId,Integer classId);
    public List<StuAchievement>  Statistical(String number,Integer classId);
}
