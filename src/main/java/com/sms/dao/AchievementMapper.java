package com.sms.dao;

import com.sms.pojo.Achievement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AchievementMapper {

    @Select("select * from achievement")
    List<Achievement> queryAllAchievement();

    @Select("select * from achievement where studentID=#{studentID}")
    List<Achievement> queryAchievementByStudentID(@Param("studentID") String studentID);

    @Select("select * from achievement where teacherID=#{teacherID}")
    List<Achievement> queryAchievementByTeacherID(@Param("teacherID") String teacherID);

    @Select("select * from achievement where studentName like '%${studentName}%'")
    List<Achievement> queryAchievementByStudentName(@Param("studentName") String studentName);

    @Select("select * from achievement where courseName=#{courseName}")
    List<Achievement> queryAchievementByCourseName(@Param("courseName") String courseName);

}
