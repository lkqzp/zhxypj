package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Course;
import com.briup.zhxypj.bean.CourseExample;
import com.briup.zhxypj.mapper.CourseMapper;
import com.briup.zhxypj.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() throws RuntimeException {
        CourseExample example = new CourseExample();
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;


    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Course course) throws RuntimeException {
        if (course == null) {
            throw new RuntimeException("参数为空");
        }
        if (course.getId() == null) {
            courseMapper.insert(course);
        } else {
            courseMapper.updateByPrimaryKey(course);
        }

    }

    @Override
    public List<Course> search(String key, String word) throws RuntimeException {
        word = word == null ? "" : word;
        if ((key == null || "".equals(key)) && (word == null || "".equals(word))) {
            return findAll();
        } else if ((key == null || "".equals(key)) && !"".equals(word)) {
            word = "%" + word + "%";
            return courseMapper.selectnameOrPeriod(word);
        } else if ("name".equals(key)) {
            word = "%" + word + "%";
            return courseMapper.selectName(word);
        } else if ("period".equals(key)) {
            word = "%" + word + "%";
            return courseMapper.selectPeriod(word);
        }
        return null;
    }
}


