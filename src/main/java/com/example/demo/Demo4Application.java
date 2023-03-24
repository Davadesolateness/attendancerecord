package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/14 19:14
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.attendance.dao")
public class Demo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

}
