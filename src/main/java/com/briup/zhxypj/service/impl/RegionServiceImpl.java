package com.briup.zhxypj.service.impl;

import com.briup.zhxypj.bean.Region;
import com.briup.zhxypj.bean.RegionExample;
import com.briup.zhxypj.mapper.RegionMapper;
import com.briup.zhxypj.mapper.ex.RegionEXMapper;
import com.briup.zhxypj.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements IRegionService {
    @Autowired
    private RegionMapper regionMapper;
    @Autowired
    private RegionEXMapper regionEXMapper;
    @Override
    public Region findByNew() throws RuntimeException {
       return regionEXMapper.findByNew();
    }
}
