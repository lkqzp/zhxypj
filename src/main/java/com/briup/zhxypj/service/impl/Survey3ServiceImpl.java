package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.*;
import com.briup.zhxypj.bean.ex.Survey3EX;
import com.briup.zhxypj.mapper.DepartmentMapper;
import com.briup.zhxypj.mapper.OptionsMapper;
import com.briup.zhxypj.mapper.QqnMapper;
import com.briup.zhxypj.mapper.SurveyMapper;
import com.briup.zhxypj.mapper.ex.Survey3EXMapper;
import com.briup.zhxypj.service.ISurvey3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Survey3ServiceImpl implements ISurvey3Service {
    @Autowired
    private Survey3EXMapper surveyEXMapper;
    @Autowired
    private SurveyMapper surveyMapper;
    @Autowired
    private QqnMapper qqnMapper;
    @Autowired
    private OptionsMapper optionsMapper;
    @Override
    public List<Survey3EX> findAll() throws RuntimeException {
        List<Survey3EX> surveys = surveyEXMapper.findAll();
        return  surveys;
    }

    @Override
    public List<Survey3EX> findByCondi(String word) throws RuntimeException {
        word = word == null ? "" : word;
        if(word == null || "".equals(word)){
            return  findAll();
        }else {
            word  = "%" + word + "%";
            List<Survey3EX> surveys = surveyEXMapper.findByCondi(word);
            return surveys;
        }

    }

    @Override
    public Survey3EX findById(int id,String status) throws RuntimeException {

        Survey survey = surveyMapper.selectByPrimaryKey(id);
        System.out.println(survey.getStatus());
        if("审核".equals(survey.getStatus())){
            if(status != null)
            surveyEXMapper.update(id,status);

        }else if("未开启".equals(survey.getStatus())){
            throw new RuntimeException("课调未开启");
        }else if("开启".equals(survey.getStatus())){
            throw new RuntimeException("课调未结束");
        }else if("结束".equals(survey.getStatus())){
            throw  new RuntimeException("课调未开启审核");
        }else if("审核通过".equals(survey.getStatus()) || "审核未通过".equals(survey.getStatus())){
            throw new RuntimeException("课调已审核");
        }
        return surveyEXMapper.findById(id);

    }

    @Override
    public Survey3EX selectById(int id) throws RuntimeException {

        return surveyEXMapper.findById(id);
    }

    @Override
    public List<Survey3EX> allFind() throws RuntimeException {
        return surveyEXMapper.allFind();
    }

    @Override
    public Survey3EX allFindById(int id) throws RuntimeException {
        average(id);
        Survey survey = surveyMapper.selectByPrimaryKey(id);

        if(!"审核通过".equals(survey.getStatus())){
            throw new RuntimeException("未审核");
        }
        return surveyEXMapper.allFindById(id);
    }

    @Override
    public void average(int id) throws RuntimeException {
        Survey survey = surveyMapper.selectByPrimaryKey(id);
        QqnExample qqnExample = new QqnExample();
        qqnExample.createCriteria().andQuestionnaireIdEqualTo(survey.getQuestionnaireId());
        List<Qqn> qqns =qqnMapper.selectByExample(qqnExample);


        int count = 0;
        int sum = 0;
        for(Qqn qqn : qqns){
            OptionsExample optionsExample = new OptionsExample();
            optionsExample.createCriteria().andQuestionIdEqualTo( qqn.getQuestionId());
            List<Options> options = optionsMapper.selectByExample(optionsExample);
                for(Options options1 : options){
                    sum += options1.getScore();
                    count += 1;
                }
        }
        double average = sum * 1.0 / count ;
        surveyEXMapper.updateAvg(average,id);
    }


}
