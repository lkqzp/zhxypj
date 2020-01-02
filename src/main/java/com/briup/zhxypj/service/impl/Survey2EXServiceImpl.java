package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;
import com.briup.zhxypj.mapper.SurveyMapper;
import com.briup.zhxypj.mapper.ex.Survey2EXMapper;
import com.briup.zhxypj.service.ISurvey2EXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        if ("未开启".equals(survey2EX.getStatus())){
            int code = (int)(Math.random() * 9000 + 1000);
            long code1=code*new Date().getTime();
            String code2=code1 +  "";
            String code3=code2.substring(0,4);
            int code4=Integer.parseInt(code3);
            survey2EXMapper.updateCode(code4,id);
            String status="开启";
            survey2EXMapper.updateStatus(status,id);
            return survey2EXMapper.startSurvey(id);

        }else if ("开启".equals(survey2EX.getStatus())){
            String status="结束";
            survey2EXMapper.updateStatus(status,id);
            throw new RuntimeException("课调结束");
        }
        return survey2EX;
    }

}
