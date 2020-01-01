package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.ex.SurveyEXl;
import com.briup.zhxypj.service.ISurveyEXlService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "课调搜索")
@RestController
@RequestMapping("/Seachersurvey")
public class SurveyEXlController {
    @Autowired
    private ISurveyEXlService surveyEXlService;
    @PostMapping("/findAll")
    @ApiOperation(value = "课调查询")
    public Message find(){
        List<SurveyEXl> list=surveyEXlService.findAllSurvey();
        return MessageUtil.success(list);
    }
    @PostMapping("/selectSome")
    @ApiOperation(value = "模糊查询")
    public Message select(String word){
        List<SurveyEXl> list=surveyEXlService.selectByWord(word);
        return MessageUtil.success(list);
    }
}
