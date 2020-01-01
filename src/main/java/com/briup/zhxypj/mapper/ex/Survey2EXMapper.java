package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.Survey;
import com.briup.zhxypj.bean.ex.Survey2EX;

import java.util.List;

public interface Survey2EXMapper {
    List<Survey2EX> findAll();
    List<Survey2EX> selectByMessage(String word);

    Survey2EX startSurvey(int id);
    void updateCode(int code,int id);
    void updateStatus(String status,int id);
}
