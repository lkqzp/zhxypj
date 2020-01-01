package com.briup.zhxypj.service;



import com.briup.zhxypj.bean.ex.SurveyEXl;

import java.util.List;

public interface ISurveyEXlService {
    List<SurveyEXl> findAllSurvey() throws RuntimeException;
    List<SurveyEXl> selectByWord(String word) throws RuntimeException;
}
