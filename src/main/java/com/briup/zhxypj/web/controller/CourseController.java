package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Course;
import com.briup.zhxypj.service.ICourseService;
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
@RequestMapping("/course")
@Api(description = "课程管理")
public class CourseController {
    @Autowired
    private ICourseService iCourseService;
    @GetMapping("/selectAll")
    @ApiOperation(value="查询所有课程")
    public Message selectAll(){
        List<Course> courses=iCourseService.findAll();
        return MessageUtil.success(courses);
    }
    @GetMapping("/deleteById")
    @ApiOperation(value="根据id删除")
    public Message deleteById(int id){
        iCourseService.deleteById(id);
        return MessageUtil.success();
    }
    @PostMapping("/addcourse")
    @ApiOperation(value="添加课程")
    public Message addcourse(Course course){
        iCourseService.saveOrUpdate(course);
        return MessageUtil.success();
    }
    @PostMapping("/updatecourse")
    @ApiOperation(value="更新课程")
    public Message updatecourse(Course course){
        iCourseService.saveOrUpdate(course);
        return MessageUtil.success(course);
    }
    @GetMapping("/search")
    @ApiOperation(value="查询")
    public Message search(String key,String word){
        List<Course> courses=iCourseService.search(key, word);
        return MessageUtil.success(courses);
    }
    @GetMapping("deleteAll")
    public Message deleteAll(int[] ids){
        for(int id: ids){
            iCourseService.deleteById(id);

        }
        return MessageUtil.success();
    }
}
