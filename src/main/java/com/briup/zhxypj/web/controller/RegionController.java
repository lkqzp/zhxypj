package com.briup.zhxypj.web.controller;

import com.briup.zhxypj.bean.Region;
import com.briup.zhxypj.service.IRegionService;
import com.briup.zhxypj.util.Message;
import com.briup.zhxypj.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Region")
@Api(description = "校园查询")
public class RegionController {
    @Autowired
    private IRegionService regionService;
    @GetMapping("/findByNew")
    @ApiOperation(value = "查询最新校园信息")
    public Message findByNew(){
        Region region = regionService.findByNew();
        return MessageUtil.success(region);
    }


}
