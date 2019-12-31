package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.ex.Survey2EX;

public interface ISurvey2EXService {
    Survey2EX selectByMessage(String word) throws RuntimeException;
}
