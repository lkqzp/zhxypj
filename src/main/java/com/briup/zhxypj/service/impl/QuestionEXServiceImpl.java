package com.briup.zhxypj.service.impl;


import com.briup.zhxypj.bean.ex.QuestionExl;
import com.briup.zhxypj.mapper.ex.QuestionEXMapper;
import com.briup.zhxypj.service.IQuestionEXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionEXServiceImpl implements IQuestionEXService {
    @Autowired
    private QuestionEXMapper questionEXMapper;


    @Override
    public List<QuestionExl> findAll() throws RuntimeException {
        List<QuestionExl> list=questionEXMapper.findAll();
        return list;
    }

    @Override
    public List<QuestionExl> findByName(String word) throws RuntimeException {
        word = word == null ? "" : word;
        if (word==null&&"".equals(word)){
            return findAll();
        }else if (!"".equals(word)){
            word="%"+word+"%";
            return questionEXMapper.findByName(word);
        }
        return null;
    }


}
