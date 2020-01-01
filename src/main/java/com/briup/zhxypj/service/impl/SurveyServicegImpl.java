package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.SurveyExample;
import com.briup.zhxypj.bean.ex.SurvryExg;
import com.briup.zhxypj.mapper.ex.SurveyExgMapper;
import com.briup.zhxypj.service.ISurveyServiceg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class SurveyServicegImpl implements ISurveyServiceg {
    @Autowired
    private SurveyExgMapper surveyExgMapper;

    @Override
    public SurvryExg selectById(int id) throws RuntimeException {
        SurvryExg survryExg=surveyExgMapper.searchSurveyById(id);
        return survryExg;
    }


//    @Override
//    public void addOrupdate(SurvryExg survryExg) throws RuntimeException {
//        SurveyExample surveyExample = new SurveyExample();
//
//
//
//    }
}
