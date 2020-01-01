package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.ex.QuestionEX;
import com.briup.zhxypj.bean.ex.SurvryExg;



public interface SurveyExgMapper {
    SurvryExg searchSurveyById(int id);
    QuestionEX selectById(int id) ;
}
