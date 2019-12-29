package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Department;
import com.briup.zhxypj.bean.DepartmentExample;
import com.briup.zhxypj.mapper.DepartmentMapper;
import com.briup.zhxypj.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> findAll() throws RuntimeException {
        return departmentMapper.selectByExample(new DepartmentExample());
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Department department) throws RuntimeException {

        if (department==null){
            throw new RuntimeException("参数为空");
        }else if(department.getId()==null){
            departmentMapper.insert(department);
        }else {

            departmentMapper.updateByPrimaryKey(department);
        }
    }

    @Override
    public List<Department> search(String key) throws RuntimeException {

        key=key  == null? "" :key;
        if (key==null||"".equals(key)){

            return findAll();
        }else if (!"".equals(key)){

            key ="%"+ key +"%";
            return departmentMapper.selectNameOrDes(key);
        }
        return null;

    }

    @Override
    public Department selectById(int id) throws RuntimeException {
        Department department=departmentMapper.selectByPrimaryKey(id);
        return department;
    }


}
