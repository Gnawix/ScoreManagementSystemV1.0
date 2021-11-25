package com.sms.pojo;

public class Achievement {
    private int studentID;
    private String studentName;
    private int courseID;
    private String courseName;
    private int score;
    private String teacherName;
    private String teacherID;


    public Achievement() {
    }

    public Achievement(int studentID, String studentName, int courseID, String courseName, int score, String teacherName, String teacherID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.courseID = courseID;
        this.courseName = courseName;
        this.score = score;
        this.teacherName = teacherName;
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
