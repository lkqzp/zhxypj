package com.briup.zhxypj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.briup.zhxypj.mapper")
public class ZhxypjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhxypjApplication.class, args);
    }

}
