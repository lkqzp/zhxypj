package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.Questionnaire;
import com.briup.zhxypj.bean.ex.QuestionEX;

public interface QuestionnaireEXMapper {
    void addQuestionnaire(Questionnaire questionnaire);
    QuestionEX selectById(int id) ;

}
