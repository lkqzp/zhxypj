
package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Department;
import com.briup.zhxypj.service.IDepartmentService;
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

import java.util.List;

@RestController
@Api(description = "年级管理")
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @PostMapping("/find")
    @ApiOperation(value = "年级查询")
    public Message findAll(){
    List<Department> list=departmentService.findAll();
    return MessageUtil.success(list);
    }
    @GetMapping("/delete")
    @ApiOperation(value = "根据id删除年级")
    public Message delete(int id){
        departmentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @PostMapping("/save")
    @ApiOperation(value = "添加/修改年级")
    public Message add( Department department){
        departmentService.saveOrUpdate(department);
        return MessageUtil.success("添加成功");
    }
    @PostMapping("/search")
    @ApiOperation(value ="根据关键字查询")
    public Message search(String key){

        List<Department> list=departmentService.search(key);
        return MessageUtil.success(list);
    }
    @PostMapping("/select")
    @ApiOperation(value = "根据id查询")
    @ApiImplicitParam(name = "id",value = "年级编号",paramType = "query",dataType = "int",required = true)
    public Message selectById(int id){

        Department department=departmentService.selectById(id);
        return MessageUtil.success(department);

    }
    @GetMapping("/deleteSome")
    @ApiOperation(value = "批量删除")
    public Message deleteSome(int[] ids){

       for (int id:ids){
           //System.out.println(id);
           departmentService.deleteById(id);
       }
        return MessageUtil.success("删除成功");
    }
}
