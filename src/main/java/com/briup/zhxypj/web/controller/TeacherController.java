package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Teacher;
import com.briup.zhxypj.service.ITeacherService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "教师管理")
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private  ITeacherService teacherService;
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有教师")
    public Message findAll(){
        List<Teacher> teachers = teacherService.findAll();
        return MessageUtil.success(teachers);
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据教师ID删除")
    @ApiImplicitParam(name = "id" ,value = "id" ,paramType = "query" ,dataType = "int" ,required = true)
    public Message deleteById(int id){
        teacherService.deleteById(id);
        return MessageUtil.success();
    }
    @GetMapping("/findById")
    @ApiOperation(value = "根据教师ID查询")
    @ApiImplicitParam(name = "id" ,value = "id" ,paramType = "query" ,dataType = "int",required = true)
    public Message findById(int id){
        Teacher teacher = teacherService.findById(id);
        return  MessageUtil.success(teacher);
    }
    @PostMapping("/addTeacher")
    @ApiOperation(value = "添加教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "教师ID" ,paramType = "query" ,dataType = "int" ),
            @ApiImplicitParam(name = "name" ,value = "姓名" ,paramType = "query" ,dataType = "String" ),
            @ApiImplicitParam(name = "gender" ,value = "性别" ,paramType = "query" ,dataType = "String" ),
            @ApiImplicitParam(name = "birthday" ,value = "出生日期" ,paramType = "query" ,dataType = "Date" ),
            @ApiImplicitParam(name = "startday" ,value = "入职日期" ,paramType = "query" ,dataType = "Date" )

    })
    public Message addTeacher(Teacher teacher){
        teacherService.saveOrUpdate(teacher);
        return  MessageUtil.success();
    }
    @PostMapping("/update")
    @ApiOperation(value = "更改教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "教师ID" ,paramType = "query" ,dataType = "int" ,required = true),
            @ApiImplicitParam(name = "name" ,value = "姓名" ,paramType = "query" ,dataType = "String" ),
            @ApiImplicitParam(name = "gender" ,value = "性别" ,paramType = "query" ,dataType = "String" ),
            @ApiImplicitParam(name = "birthday" ,value = "出生日期" ,paramType = "query" ,dataType = "Date" ),
            @ApiImplicitParam(name = "startday" ,value = "入职日期" ,paramType = "query" ,dataType = "Date" )

    })

    public Message update(Teacher teacher){
        teacherService.saveOrUpdate(teacher);
        return MessageUtil.success();
    }
    @GetMapping("selectByCondi")
    @ApiOperation(value = "根据关键字查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key" ,value = "关键字类型(教师姓名、性别)" ,paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name = "word" ,value = "关键字" ,paramType = "query" ,dataType = "String")
    })
    public Message selectByCondi(String key,String word){
        List<Teacher> teachers = teacherService.findByKey(key,word);
        return MessageUtil.success(teachers);
    }
    @GetMapping("/deleteMore")
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids" ,value="批量删除多个教师id" ,paramType = "query" ,dataType = "String" ,required = true,allowMultiple = true)

    public Message deleteMore(String[] ids){
        teacherService.deleteMore(ids);
        return MessageUtil.success();
    }

}
