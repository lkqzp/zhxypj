package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Teacher;

import javax.management.RuntimeMBeanException;
import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll() throws RuntimeMBeanException;
    void deleteById(int id) throws  RuntimeMBeanException;
    void saveOrUpdate(Teacher teacher) throws RuntimeMBeanException;
    Teacher findById(int id) throws  RuntimeMBeanException;
    List<Teacher> findByKey(String key,String word) throws  RuntimeMBeanException;
    void deleteMore(String[] ids)throws RuntimeMBeanException;
}
