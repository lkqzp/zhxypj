package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.ex.Survey3EX;

import java.util.List;

public interface ISurvey3Service {
    List<Survey3EX> findAll() throws RuntimeException;
    List<Survey3EX> findByCondi(String word) throws RuntimeException;
}
