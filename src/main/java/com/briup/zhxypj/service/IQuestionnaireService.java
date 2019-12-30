package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.Questionnaire;
import com.briup.zhxypj.bean.ex.QuestionEX;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws  RuntimeException;
    void deleteById(int id) throws  RuntimeException;
    void  saveOrUpdate(Questionnaire questionnaire,int[] ids) throws  RuntimeException;
    List<Question> selectAll() throws RuntimeException;

    List<Questionnaire> findByCondi(String word) throws RuntimeException;
    void delete(int[]  ids) throws RuntimeException;

    void add(Questionnaire questionnaire,int[] ids) throws  RuntimeException;
    QuestionEX findById(int id) throws RuntimeException;

}
