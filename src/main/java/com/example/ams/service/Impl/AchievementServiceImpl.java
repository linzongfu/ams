package com.example.ams.service.Impl;

import com.example.ams.mapper.AchievementMapper;
import com.example.ams.model.Achievement;
import com.example.ams.model.StuAchievement;
import com.example.ams.service.AchievementService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AchievementService")
public class AchievementServiceImpl  implements AchievementService {
    @Autowired
    AchievementMapper achievementMapper;

    @Override
    public Page<Achievement> getAllAchievement(Achievement achievement) {
        return null;
    }

    @Override
    public int addAchievement(Achievement achievement) {
        return achievementMapper.insert(achievement);
    }

    @Override
    public int deleteAchievement(Integer id) {
        return 0;
    }

    @Override
    public int editAchievement(Achievement achievement) {
        return achievementMapper.updateByPrimaryKey(achievement);
    }

    @Override
    public Achievement getAchievementById(Integer id) {
        return null;
    }

    @Override
    public List<Achievement> exitAchivement(String number, int ccid) {
        return achievementMapper.exsisAchivement(number,ccid);
    }

    @Override
    public List<StuAchievement> usualPerformance(String number, Integer semesterId, Integer classId) {
        return achievementMapper.usualPerformance(number,semesterId,classId);
    }

    @Override
    public List<StuAchievement> Statistical(String number, Integer classId) {
        return achievementMapper.Statistical(number,classId);
    }
}
