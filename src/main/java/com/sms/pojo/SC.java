package com.sms.pojo;

public class SC {
    private int studentID;
    private int courseID;
    private float score;

    public SC() {
    }

    public SC(int studentID, int courseID, float score) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.score = score;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
