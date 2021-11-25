package com.sms.service;

import com.sms.dao.AchievementMapper;
import com.sms.pojo.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    public List<Achievement> queryAllAchievement(){
        return achievementMapper.queryAllAchievement();
    }

    public List<Achievement> queryAchievementByStudentID(String studentID){
        return achievementMapper.queryAchievementByStudentID(studentID);
    }

    public List<Achievement> queryAchievementByTeacherID(String teacherID){
        return achievementMapper.queryAchievementByTeacherID(teacherID);
    }

    public List<Achievement> queryAchievementByStudentName(String studentName){
        return achievementMapper.queryAchievementByStudentName(studentName);
    }

    public List<Achievement> queryAchievementByCourseName(String courseName){
        return achievementMapper.queryAchievementByCourseName(courseName);
    }
}
