package com.briup.zhxypj.service;


import com.briup.zhxypj.bean.ex.QuestionExl;

import java.util.List;

public interface IQuestionEXService {
     List<QuestionExl> findAll() throws RuntimeException;
     List<QuestionExl> findByName(String key) throws RuntimeException;
}
