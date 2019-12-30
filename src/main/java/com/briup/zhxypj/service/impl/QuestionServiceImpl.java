package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Options;
import com.briup.zhxypj.bean.OptionsExample;
import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.QuestionExample;
import com.briup.zhxypj.mapper.OptionsMapper;
import com.briup.zhxypj.mapper.QuestionMapper;
import com.briup.zhxypj.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private OptionsMapper optionsMapper;


    @Override
    public void deleteById(int id) throws RuntimeException {
        questionMapper.deleteByPrimaryKey(id);
        OptionsExample optionsExample=new OptionsExample();
        optionsExample.createCriteria().andQuestionIdEqualTo(id);
        optionsMapper.countByExample(optionsExample);
    }

    @Override
    public void saveOrUpdate(Question question, List<Options> options) throws RuntimeException {
        if(question==null){
            throw new RuntimeException("参数为空");
        }
        if(question.getId()==null){
            questionMapper.insert(question);
            for(Options options1:options){
                options1.setQuestionId(question.getId());
                optionsMapper.insert(options1);
            }
        }
        else{
            questionMapper.updateByPrimaryKey(question);
            for(Options options1:options){
                options1.setQuestionId(question.getId());
                optionsMapper.updateByPrimaryKey(options1);
            }
        }

    }




}
