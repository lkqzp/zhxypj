package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.Questionnaire;
import com.briup.zhxypj.service.IQuestionnaireService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/questionnire")
@Api(description = "问卷管理")
public class QuestionnireController {
    @Autowired
    private IQuestionnaireService questionnaireService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询全部")
    public Message findAll(){
        List<Questionnaire> questionnaires = questionnaireService.findAll();
        return MessageUtil.success(questionnaires);
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据ID删除问卷")
    @ApiImplicitParam(name = "id",value = "问卷ID",paramType = "query" ,dataType = "int")
    public Message deleteById(int id){
        questionnaireService.deleteById(id);
        return  MessageUtil.success();
    }
    @GetMapping("/findById")
    @ApiOperation(value = "根据ID查询问卷")
    @ApiImplicitParam(name = "id",value = "问卷ID",paramType = "query" ,dataType = "int")
    public Message findById(int id){
        Questionnaire questionnaire =questionnaireService.findById(id);
        return MessageUtil.success(questionnaire);
    }
    @GetMapping("/findByCondi")
    @ApiOperation(value = "根据关键字查询")
    @ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String")
    public Message findByCondi(String word){
        List<Questionnaire> questionnaires = questionnaireService.findByCondi(word);
        return MessageUtil.success(questionnaires);
    }

    @PostMapping("/add")
    public Message add(Questionnaire questionnaire,int[] ids) {

      //  questionnaireService.saveOrUpdate(questionnaire);
        return  MessageUtil.success();

    }
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有的问题")
    public Message selectAll(){
        List<Question> questions = questionnaireService.selectAll();
        return MessageUtil.success(questions);
    }
    @GetMapping("/delete")
    @ApiOperation(value = "批量删除")
    @ApiImplicitParam(name = "ids" ,value = "多个问卷ID" ,paramType = "query",dataType = "int",allowMultiple = true)
    public  Message delete(int[] ids){
        questionnaireService.delete(ids);
        return MessageUtil.success();
    }
}
