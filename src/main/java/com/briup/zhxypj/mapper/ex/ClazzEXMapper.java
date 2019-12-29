package com.briup.zhxypj.mapper.ex;

import com.briup.zhxypj.bean.ex.ClazzEx;

import java.util.List;

public interface ClazzEXMapper {
    List<ClazzEx> findAll();
    List<ClazzEx> selectWebuiOrDes(String word);
    List<ClazzEx> selectWebui(String word);
    List<ClazzEx> selectDes(String word);
}
