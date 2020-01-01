package com.briup.zhxypj.bean.ex;

import com.briup.zhxypj.bean.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SurvryExg implements Serializable {
    private Integer id;

    private String status;
    private Department department;
    private Course course;
    private Clazz clazz;
    private Teacher teacher;
    private List<Question> question;
    private  Integer average;
    private Date surveyday;
    private int code;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    private Questionnaire  questionnaire;

    public void setQuestion(List<Question> question) {
        this.question = question;
    }





    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getSurveyday() {
        return surveyday;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Clazz getClzz() {
        return clazz;
    }

    public void setClzz(Clazz clzz) {
        this.clazz = clzz;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }
}
