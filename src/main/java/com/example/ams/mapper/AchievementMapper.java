package com.example.ams.mapper;

import com.example.ams.model.Achievement;
import com.example.ams.model.StuAchievement;

import java.util.List;

public interface AchievementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    Achievement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKeyWithBLOBs(Achievement record);

    int updateByPrimaryKey(Achievement record);

    List<Achievement> exsisAchivement(String number, int ccid);

    List<StuAchievement> usualPerformance(String number, Integer semesterId, Integer classId);

    List<StuAchievement> Statistical(String number, Integer classId);
}