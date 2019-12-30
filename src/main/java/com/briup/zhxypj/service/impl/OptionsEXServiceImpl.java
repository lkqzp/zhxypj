package com.briup.zhxypj.service.impl;


import com.briup.zhxypj.bean.ex.OptionsEX;
import com.briup.zhxypj.bean.ex.OptionsExl;
import com.briup.zhxypj.mapper.ex.OptionsEXMapper;
import com.briup.zhxypj.service.IOptionsEXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsEXServiceImpl implements IOptionsEXService {
    @Autowired
    private OptionsEXMapper optionsEXMapper;
    @Override
    public List<OptionsExl> findAllOptions() throws RuntimeException {
        List<OptionsExl> list=optionsEXMapper.findAll();
        return list;
    }




}
