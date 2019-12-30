package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Teacher;
import com.briup.zhxypj.bean.TeacherExample;
import com.briup.zhxypj.mapper.TeacherMapper;
import com.briup.zhxypj.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import javax.management.RuntimeMBeanException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    @Override
    public List<Teacher> findAll() throws RuntimeMBeanException {
        TeacherExample example = new TeacherExample();
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        return teachers;
    }

    @Override
    public void deleteById(int id) throws RuntimeMBeanException {
        teacherMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void saveOrUpdate(Teacher teacher) throws RuntimeMBeanException {
        if(teacher ==  null){
            throw new RuntimeException("不能为空");
        }
        if(teacher.getId() == null){

            teacherMapper.insert(teacher);
        }else{
            teacherMapper.updateByPrimaryKey(teacher);
        }
    }

    @Override
    public Teacher findById(int id) throws RuntimeMBeanException {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    @Override
    public List<Teacher> findByKey(String key, String word) throws RuntimeMBeanException {
        TeacherExample example = new TeacherExample();

        word = word == null ? "":word;
        if((key == null || "".equals(key) ) && (word == null || "".equals(word))){
            return findAll();
        }else if((key == null || "".equals(key) ) && !"".equals(word) ){
            word = "%" + word + "%";

//            return teacherEXMapper.findByName(word);
                example.createCriteria().andNameLike(word);
                return teacherMapper.selectByExample(example);
        }else if("教师姓名".equals(key)){
            word = "%" + word + "%";
//            return  teacherEXMapper.findByName(word);
                example.createCriteria().andNameLike(word);
            return teacherMapper.selectByExample(example);
        }else if("性别".equals(key) || !"".equals(word)){
            word = "%" + word + "%";
            example.createCriteria().andGenderLike(word);
            return teacherMapper.selectByExample(example);
        }
        return  null;
    }

    @Override
    public void deleteMore(String[] ids) throws RuntimeMBeanException {
        for(int i = 0; i < ids.length;i++){
            int id = Integer.parseInt(ids[i]);
            teacherMapper.deleteByPrimaryKey(id);
        }

    }


}
