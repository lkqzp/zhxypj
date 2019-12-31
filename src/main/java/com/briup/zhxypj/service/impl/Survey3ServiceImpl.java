package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.DepartmentExample;
import com.briup.zhxypj.bean.ex.Survey3EX;
import com.briup.zhxypj.mapper.DepartmentMapper;
import com.briup.zhxypj.mapper.ex.Survey3EXMapper;
import com.briup.zhxypj.service.ISurvey3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Survey3ServiceImpl implements ISurvey3Service {
    @Autowired
    private Survey3EXMapper surveyEXMapper;
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
}
