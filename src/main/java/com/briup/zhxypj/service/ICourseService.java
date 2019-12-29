package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll() throws  RuntimeException;
    void deleteById(int id) throws RuntimeException;
    void saveOrUpdate(Course course) throws RuntimeException;
    List<Course> search(String  key,String word) throws RuntimeException;
}
