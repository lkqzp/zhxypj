package com.briup.zhxypj.bean.ex;

import com.briup.zhxypj.bean.Clazz;
import com.briup.zhxypj.bean.Course;
import com.briup.zhxypj.bean.Questionnaire;
import com.briup.zhxypj.bean.Teacher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Survey2EX implements Serializable {
    private Integer id;
    private String status;
    private Integer code;
    private Date surveyday;
    private Integer departmentId;
    private Integer courseId;
    private Integer clazzId;
    private Integer userId;
    private Integer questionnaireId;
    private Double average;

    /*private Clazz clazz;
    private Course course;
    private Questionnaire questionnaire;
    private Teacher teacher;*/
    private Clazz2EX clazz2EX;
    private Course2EX course2EX;
    private Questionnaire2EX questionnaire2EX;
    private Teacher2EX teacher2EX;
    private Department2EX department2EX;

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

    public Date getSurveyday() {
        return surveyday;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

     /*public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }*/

    public Clazz2EX getClazz2Ex() {
        return clazz2EX;
    }

    public void setClazz2Ex(Clazz2EX clazz2Ex) {
        this.clazz2EX = clazz2Ex;
    }

    public Course2EX getCourse2EX() {
        return course2EX;
    }

    public void setCourse2EX(Course2EX course2EX) {
        this.course2EX = course2EX;
    }

    public Questionnaire2EX getQuestionnaire2EX() {
        return questionnaire2EX;
    }

    public void setQuestionnaire2EX(Questionnaire2EX questionnaire2EX) {
        this.questionnaire2EX = questionnaire2EX;
    }

    public Teacher2EX getTeacher2EX() {
        return teacher2EX;
    }

    public void setTeacher2EX(Teacher2EX teacher2EX) {
        this.teacher2EX = teacher2EX;
    }

    public Department2EX getDepartment2EX() {
        return department2EX;
    }

    public void setDepartment2EX(Department2EX department2EX) {
        this.department2EX = department2EX;
    }
}
