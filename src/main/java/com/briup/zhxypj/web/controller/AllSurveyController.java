package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey3EX;
import com.briup.zhxypj.service.ISurvey3Service;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allSurvey")
@Api(description = "全部课调")
public class AllSurveyController {
    @Autowired
    private ISurvey3Service survey3Service;
    @GetMapping("/allFind")
    @ApiOperation(value = "全部课调")
    public Message allFind(){
        List<Survey3EX> survey3EXES = survey3Service.allFind();
        return MessageUtil.success(survey3EXES);
    }
    @GetMapping("/allFindById")
    @ApiOperation(value = "全部课调的预览")
    @ApiImplicitParam(name = "id",value = "课调的ID",paramType = "query",dataType = "int" ,required = true)
    public Message allFindById(int id){
        Survey3EX survey3EX = survey3Service.allFindById(id);
        return MessageUtil.success(survey3EX);
    }
}
