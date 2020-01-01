package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.SurveyExample;
import com.briup.zhxypj.mapper.SurveyMapper;
import com.briup.zhxypj.service.ISurveyServicezp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service

public class SurveyServiceImplzp implements ISurveyServicezp {

    @Autowired
    private SurveyMapper surveyMapper;
    @Override
    public void saveOrUpdate(Survey survey) throws RuntimeException {
        if(survey==null){
            throw new RuntimeException("参数为空");
        }
        if(survey.getId()==null){
            survey.setSurveyday(new Date());
            if(survey.getStatus().equals("开启")){
                Random random=new Random();
                survey.setCode(random.nextInt(90000)+10000);


            }
            surveyMapper.insert(survey);

        }
        else{
            surveyMapper.updateByPrimaryKey(survey);
        }


    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        surveyMapper.deleteByPrimaryKey(id);

    }


}
