package com.briup.zhxypj.mapper.ex;



import com.briup.zhxypj.bean.ex.SurveyEXl;

import java.util.List;

public interface SurveyEXlMapper {
    List<SurveyEXl> findAllSurvey();
    List<SurveyEXl> selectByWord(String word);


}
