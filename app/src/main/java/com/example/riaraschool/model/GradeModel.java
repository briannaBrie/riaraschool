package com.example.riaraschool.model;

public class GradeModel {
//ignored ID
    private String subject;
    private String grade_name;
    private String lesson_desc;
    private int no_of_lessons;
    private String avatar;

    public GradeModel(String subject, String grade_name, String lesson_desc, int no_of_lessons, String avatar) {
        this.subject = subject;
        this.grade_name = grade_name;
        this.lesson_desc = lesson_desc;
        this.no_of_lessons = no_of_lessons;
        this.avatar = avatar;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public String getLesson_desc() {
        return lesson_desc;
    }

    public void setLesson_desc(String lesson_desc) {
        this.lesson_desc = lesson_desc;
    }

    public int getNo_of_lessons() {
        return no_of_lessons;
    }

    public void setNo_of_lessons(int no_of_lessons) {
        this.no_of_lessons = no_of_lessons;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


}
