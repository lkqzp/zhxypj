package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.ex.Survey2EX;
import com.briup.zhxypj.service.ISurvey2EXService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "课调监控")
@RequestMapping("/Survey2")
public class Survey2EXController {

    @Autowired
    private ISurvey2EXService iSurvey2EXService;
    @GetMapping("/findByMessage")
    @ApiOperation(value = "/查询课调")
    @ApiImplicitParam(name = "word",value = "String",paramType = "query",dataType = "String")
    public Message findByMessage(String word){
        Survey2EX survey2EX=iSurvey2EXService.selectByMessage(word);
        return MessageUtil.success(survey2EX);
    }
}
