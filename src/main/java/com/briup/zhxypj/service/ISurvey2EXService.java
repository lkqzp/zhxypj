package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;

import java.util.List;

public interface ISurvey2EXService {
    List<Survey2EX> selectByMessage(String word) throws RuntimeException;
    List<Survey2EX> findAll() throws RuntimeException;

    Survey2EX startOrOverSurvey(int id) throws RuntimeException;

    List<Survey2EX> selectByWord(String depart,String clazz,String course,String quest,String word) throws RuntimeException;
}
