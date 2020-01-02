package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;
import com.briup.zhxypj.bean.ex.Survey3EX;
import com.briup.zhxypj.service.ISurvey2EXService;
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
@RequestMapping("/allSurvey")
@Api(description = "全部课调管理")
public class AllSurveyController {
    @Autowired
    private ISurvey3Service survey3Service;
    @Autowired
    private ISurvey2EXService iSurvey2EXService;

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


    @GetMapping("/selectByWord")
    @ApiOperation(value = "根据关键字查询")
    @ApiImplicitParams({@ApiImplicitParam(name="depart",value = "年级名字",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="clazz",value = "班级名字",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="course",value = "课程名字",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="quest",value = "问卷名字",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name="word",value = "关键字",paramType = "query",dataType = "String")})
    public Message selectByWord(String depart,String clazz,String course,String quest,String word){
        List<Survey2EX> list=iSurvey2EXService.selectByWord(depart, clazz, course, quest, word);
        return MessageUtil.success(list);
    }
}
