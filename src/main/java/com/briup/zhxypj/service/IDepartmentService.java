package com.briup.zhxypj.service;

import com.briup.zhxypj.bean.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll() throws RuntimeException;
    void deleteById(int id) throws RuntimeException;

    void saveOrUpdate(Department department) throws RuntimeException;
    List<Department> search(String key) throws RuntimeException;

    Department selectById(int id) throws RuntimeException;
}
