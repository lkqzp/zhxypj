package com.briup.zhxypj.bean.ex;

import java.io.Serializable;

public class OptionsExl implements Serializable {
    private Integer id;

    private String label;

    private String name;

    private Integer score;

    private QuestionEX questionEX;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public QuestionEX getQuestionEX() {
        return questionEX;
    }

    public void setQuestionEX(QuestionEX questionEX) {
        this.questionEX = questionEX;
    }
}
