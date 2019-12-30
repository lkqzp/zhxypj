package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Options;
import com.briup.zhxypj.bean.Question;

import java.util.List;

public interface IQuestionService {
    void deleteById(int id) throws RuntimeException;
    void  saveOrUpdate(Question question, List<Options> options) throws  RuntimeException;
}
