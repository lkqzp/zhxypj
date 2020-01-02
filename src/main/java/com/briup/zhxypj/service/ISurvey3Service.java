package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey3EX;

import java.util.List;

public interface ISurvey3Service {
    List<Survey3EX> findAll() throws RuntimeException;
    List<Survey3EX> findByCondi(String word) throws RuntimeException;
    Survey3EX findById(int id,String status) throws RuntimeException;
    Survey3EX selectById(int id) throws RuntimeException;

    List<Survey3EX> allFind() throws  RuntimeException;
    Survey3EX allFindById(int id) throws RuntimeException;

    void average(int id) throws RuntimeException;
 }
