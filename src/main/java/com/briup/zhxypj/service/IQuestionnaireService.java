package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Qqn;
import com.briup.zhxypj.bean.Question;
import com.briup.zhxypj.bean.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws  RuntimeException;
    void deleteById(int id) throws  RuntimeException;
    void  saveOrUpdate(Questionnaire questionnaire,int[] ids) throws  RuntimeException;
    List<Question> selectAll() throws RuntimeException;
    void insert(int question_id,int questionnaire_id) throws  RuntimeException;
    Questionnaire findById(int id) throws RuntimeException;
    List<Questionnaire> findByCondi(String word) throws RuntimeException;
    void delete(int[]  ids) throws RuntimeException;
}
