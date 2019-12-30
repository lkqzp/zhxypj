package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Options;
import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.service.IQuestionService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RestController
public class QuestionController {
    @Autowired
    private IQuestionService iQuestionService;

    @GetMapping("/deleteById")
    public Message deleteById(int id){
        iQuestionService.deleteById(id);
        return MessageUtil.success();
    }


    @GetMapping("/deleteAll")
    public Message deleteAll(int[] ids){
        for(int id:ids){
            iQuestionService.deleteById(id);
        }
        return MessageUtil.success();

    }

    @PostMapping("/addQuestion")
    public Message addQuestion(Question question,@RequestBody List<Options> options){

        iQuestionService.saveOrUpdate(question,options);
        return  MessageUtil.success(question);
    }
    @PostMapping("/update")
    public Message update(Question question,@RequestBody List<Options>options){
        iQuestionService.saveOrUpdate(question,options);
        return MessageUtil.success();
    }
}
