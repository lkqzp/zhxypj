package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.ex.Survey3EX;
import com.briup.zhxypj.service.ISurvey3Service;
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

import java.util.List;

@RestController
@RequestMapping("/survey3")
@Api(description = "课调审核")
public class Survey3Controller {
    @Autowired
    private ISurvey3Service survey3Service;
    @GetMapping("/findAll")
    public Message findAll(){
        List<Survey3EX> survey3EXES = survey3Service.findAll();
        return MessageUtil.success(survey3EXES);

    }
    @GetMapping("/findByCondi")
    @ApiOperation(value = "根据关键字进行查询")
    @ApiImplicitParam(name = "word" ,value = "关键(问卷）",paramType = "query" ,dataType = "String")
    public Message findByCondi(String word) {
        List<Survey3EX> survey3EXES = survey3Service.findByCondi(word);
        return MessageUtil.success(survey3EXES);
    }
    @GetMapping("/findById")
    @ApiOperation(value = "根据课调ID审核")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "课调ID",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "status",value = "课调的审核状态", paramType = "query",dataType = "String")
    })
    public Message findById(int id,String status){
       Survey3EX survey3EX =  survey3Service.findById(id,status);
       return MessageUtil.success(survey3EX);
    }
}
