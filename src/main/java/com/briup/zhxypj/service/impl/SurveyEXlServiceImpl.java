package com.briup.zhxypj.service.impl;


import com.briup.zhxypj.bean.ex.SurveyEXl;
import com.briup.zhxypj.mapper.ex.SurveyEXlMapper;
import com.briup.zhxypj.service.ISurveyEXlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyEXlServiceImpl implements ISurveyEXlService {
    @Autowired
    private SurveyEXlMapper surveyEXlMapper;
    @Override
    public List<SurveyEXl> findAllSurvey() throws RuntimeException {
       List<SurveyEXl> list= surveyEXlMapper.findAllSurvey();
       return list;
    }

    @Override
    public List<SurveyEXl> selectByWord(String word) throws RuntimeException {
        word=word==null ? "":word;
        if (word==null||"".equals(word)){
           return surveyEXlMapper.findAllSurvey();
        }else if (!"".equals(word)){
            word="%"+word+"%";
           return surveyEXlMapper.selectByWord(word);
        }
        return null;
    }
}
