package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.ex.SurvryExg;
import com.briup.zhxypj.service.ISurveyServiceg;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
public class SurveyControllerg {
    @Autowired
    private ISurveyServiceg surveyServiceg;
    @PostMapping("/selectById")
    public Message selectById(int id){
        SurvryExg survryExg=surveyServiceg.selectById(id);
        return MessageUtil.success(survryExg);
    }
}
