package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.ex.Survey3EX;

import java.util.List;

public interface Survey3EXMapper {
    List<Survey3EX> findAll() ;
    List<Survey3EX> findByCondi(String word);
    Survey3EX findById(int id);
    void update(int id,String status);

    List<Survey3EX> allFind();
    Survey3EX allFindById(int id);

    void updateAvg(double average,int id);
}
