package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.ex.Survey2EX;
import com.briup.zhxypj.mapper.ex.Survey2EXMapper;
import com.briup.zhxypj.service.ISurvey2EXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Survey2EXServiceImpl implements ISurvey2EXService {

    @Autowired
    private Survey2EXMapper survey2EXMapper;
    @Override
    public Survey2EX selectByMessage(String word) throws RuntimeException {
        Survey2EX survey2EX=survey2EXMapper.selectByMessage(word);
        return survey2EX;
    }
}
