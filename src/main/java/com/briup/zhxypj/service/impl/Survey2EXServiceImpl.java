package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;
import com.briup.zhxypj.mapper.SurveyMapper;
import com.briup.zhxypj.mapper.ex.Survey2EXMapper;
import com.briup.zhxypj.service.ISurvey2EXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class Survey2EXServiceImpl implements ISurvey2EXService {

    @Autowired
    private Survey2EXMapper survey2EXMapper;

    @Autowired
    private SurveyMapper surveyMapper;
    @Override
    public List<Survey2EX> selectByMessage(String word) throws RuntimeException {

        word = word == null ? "":word;
        if (word==null||"".equals(word)){
            List<Survey2EX> list=survey2EXMapper.findAll();
            return list;
        }else {
            word = "%" + word + "%";
            List<Survey2EX> list=survey2EXMapper.selectByMessage(word);
            return list;
        }
    }
    @Override
    public List<Survey2EX> findAll() throws RuntimeException {
        List<Survey2EX> list=survey2EXMapper.findAll();
        return list;
    }

    @Override
    public Survey2EX startOrOverSurvey(int id) throws RuntimeException {
        Survey2EX survey2EX=survey2EXMapper.startSurvey(id);
        if (survey2EX.getStatus()=="未开启"){
            int code=1;
            survey2EXMapper.updateCode(code,id);
            String status="开启";
            survey2EXMapper.updateStatus(status,id);
            return survey2EX;

        }else if (survey2EX.getStatus()=="开启"){
            String status="结束";
            survey2EXMapper.updateStatus(status,id);
            System.out.println("课调结束");
            return survey2EX;
        }
        System.out.println("111111111111");
        System.out.println(survey2EX.getStatus());
        System.out.println(survey2EX.getCode());
        return survey2EX;
    }

}
