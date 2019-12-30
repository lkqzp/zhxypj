package com.briup.zhxypj.web.controller;


import com.briup.zhxypj.bean.ex.OptionsEX;
import com.briup.zhxypj.bean.ex.OptionsExl;
import com.briup.zhxypj.bean.ex.QuestionEX;
import com.briup.zhxypj.bean.ex.QuestionExl;
import com.briup.zhxypj.service.IOptionsEXService;
import com.briup.zhxypj.service.IQuestionEXService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questionsearch")
@Api(description = "题库搜索")
public class QuestionEXController {

    @Autowired
    private IOptionsEXService optionsEXService;
    @Autowired
    private IQuestionEXService questionEXService;


    @PostMapping("/findAll")
    @ApiOperation(value = "题库查询")
    public Message find(){
      List<QuestionExl> list=questionEXService.findAll();
      for (QuestionExl questionEX:list) {

          List<OptionsExl> list1 =questionEX.getOptionsEXES();
          for (OptionsExl optionsEX : list1) {
              questionEX.getOptionsEXES();
          }
      }
        return MessageUtil.success(list);
    }



    @PostMapping("/selectByWord")
    @ApiOperation(value = "模糊查询")
    public Message select(String word) {
        List<QuestionExl> list = questionEXService.findByName(word);
        System.out.println(list);
        for (QuestionExl questionEX : list) {
            List<OptionsExl> list1 = questionEX.getOptionsEXES();
            for (OptionsExl optionsEX : list1) {
                questionEX.getOptionsEXES();
            }
        }
        return MessageUtil.success(list);
    }
}
