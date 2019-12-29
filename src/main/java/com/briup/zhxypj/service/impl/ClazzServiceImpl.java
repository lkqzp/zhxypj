package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Clazz;
import com.briup.zhxypj.bean.ex.ClazzEx;
import com.briup.zhxypj.mapper.ClazzMapper;
import com.briup.zhxypj.mapper.ex.ClazzEXMapper;
import com.briup.zhxypj.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClazzServiceImpl implements IClazzService {
    @Autowired
    private ClazzEXMapper clazzEXMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public List<ClazzEx> findAllEXClazz() throws RuntimeException {
        List<ClazzEx> list=clazzEXMapper.findAll();
        return list;
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        clazzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrupdate(Clazz clazz) throws RuntimeException {
        if(clazz==null){
            throw new RuntimeException("参数为空");
        }
        if(clazz.getId()==null){

            clazzMapper.insert(clazz);
        }
        else {
            clazzMapper.updateByPrimaryKey(clazz);
        }
    }

    @Override
    public List<ClazzEx> search(String key, String word) throws RuntimeException {
        word=word==null ? "":word;
        if((key==null || "".equals(key))&&(word==null|| "".equals(word))){
            System.out.println("你好");
            return findAllEXClazz();
        }
        else if(key==null ||"".equals(key)&& !"".equals(word)){
            word="%"+word+"%";
            return  clazzEXMapper.selectWebuiOrDes(word);

        }
        else if("name".equals(key)){
            word="%"+word+"%";
            System.out.println("你好hao");
            return clazzEXMapper.selectWebui(word);
        }
        else if("description".equals(key)){
            word="%"+word+"%";
            System.out.println("好");
            return  clazzEXMapper.selectDes(word);
        }
        return null;
    }


}
