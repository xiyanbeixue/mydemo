package com.xiyan.mydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 指定要扫描的Mapper类的包的路径
@MapperScan({"com.xiyan.mydemo.mapper.*"})
@SpringBootApplication
public class MydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydemoApplication.class, args);
    }

}
