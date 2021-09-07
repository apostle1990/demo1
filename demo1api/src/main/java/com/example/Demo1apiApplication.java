package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.Dao")
@SpringBootApplication
public class Demo1apiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1apiApplication.class, args);
    }

}
