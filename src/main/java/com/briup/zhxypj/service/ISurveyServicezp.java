package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Survey;

import java.util.List;


public interface ISurveyServicezp {
    void saveOrUpdate(Survey survey) throws RuntimeException;
    void deleteById(int id) throws RuntimeException;


}
