package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Clazz;
import com.briup.zhxypj.bean.ex.ClazzEx;

import java.util.List;

public interface IClazzService {
List<ClazzEx> findAllEXClazz() throws  RuntimeException;
void deleteById(int id) throws RuntimeException;
void  saveOrupdate(Clazz clazz) throws RuntimeException;
List<ClazzEx> search(String key,String word) throws RuntimeException;
}
