package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.Questionnaire;
import com.briup.zhxypj.bean.ex.QuestionEX;
import com.briup.zhxypj.service.IQuestionnaireService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/findByCondi")
    @ApiOperation(value = "根据关键字查询")
    @ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String")
    public Message findByCondi(String word){
        List<Questionnaire> questionnaires = questionnaireService.findByCondi(word);
        return MessageUtil.success(questionnaires);
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

    @PostMapping("/add")
    @ApiImplicitParam(name = "ids" ,value="批量增加id" ,paramType = "query" ,dataType = "String" ,required = true,allowMultiple = true)
    public Message add(Questionnaire questionnaire,int[] ids) {
        questionnaireService.add(questionnaire,ids);
        return  MessageUtil.success(questionnaire);

    }
    @GetMapping("/findById")
    @ApiOperation(value = "根据ID查询问卷")
    @ApiImplicitParam(name = "id",value = "问卷ID",paramType = "query" ,dataType = "int")
    public Message findById(int id){
        QuestionEX questionEX =questionnaireService.findById(id);
        return MessageUtil.success(questionEX);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
