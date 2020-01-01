package com.briup.zhxypj.bean.ex;

import com.briup.zhxypj.bean.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Survey3EX implements Serializable {
    private Integer id;

    private String status;

    private Integer code;

    private Double average;

    private Date surveyday;

    private Department3EX department;

    private Course3EX course;

    private Clazz3EX clazz;

    private List<Questionnaire> questionnaire;

    private Teacher3EX teacher;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Date getSurveyday() {
        return surveyday;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public Department3EX getDepartment() {
        return department;
    }

    public void setDepartment(Department3EX department) {
        this.department = department;
    }

    public Course3EX getCourse() {
        return course;
    }

    public void setCourse(Course3EX course) {
        this.course = course;
    }

    public Clazz3EX getClazz() {
        return clazz;
    }

    public void setClazz(Clazz3EX clazz) {
        this.clazz = clazz;
    }

    public List<Questionnaire> getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(List<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Teacher3EX getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher3EX teacher) {
        this.teacher = teacher;
    }
}
