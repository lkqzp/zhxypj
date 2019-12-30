package com.briup.zhxypj.bean.ex;

import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.Questionnaire;

import java.io.Serializable;

public class QqnEX implements Serializable {
    private Integer id;
    private Question question;
    private Questionnaire questionnaire;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
