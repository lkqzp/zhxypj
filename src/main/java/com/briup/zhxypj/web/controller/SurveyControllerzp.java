package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.service.ISurveyServicezp;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
@Api(description = "课调管理")
public class SurveyControllerzp {
    @Autowired
    private ISurveyServicezp iSurveyServicezp;
    @ApiOperation(value="添加课调管理信息")
    @PostMapping("add")
    public Message add(Survey survey){
        iSurveyServicezp.saveOrUpdate(survey);
        return MessageUtil.success();
    }
    @ApiOperation(value="更新课调管理信息")
    @PostMapping("/update")
    public Message update(Survey survey){
        iSurveyServicezp.saveOrUpdate(survey);
        return MessageUtil.success();
    }
    @ApiOperation(value = "根据id删除管理信息")
    @GetMapping("/deleteById")
    public Message deleteById(int id){
        iSurveyServicezp.deleteById(id);
        return MessageUtil.success();
    }
    @ApiOperation(value="批量删除课调管理信息")
    @GetMapping("/deleteAll")
    public Message deleteAll(int[] ids){
        for(int id:ids){
            iSurveyServicezp.deleteById(id);
        }
        return MessageUtil.success();
    }

}
