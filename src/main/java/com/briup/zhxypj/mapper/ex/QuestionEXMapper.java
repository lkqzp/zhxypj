package com.briup.zhxypj.mapper.ex;



import com.briup.zhxypj.bean.ex.QuestionExl;

import java.util.List;

public interface QuestionEXMapper {
    List<QuestionExl> findAll();


    List<QuestionExl> search(String key);
    List<QuestionExl> findByName(String word);

}
