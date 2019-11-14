package com.radebit.smartpi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.radebit.smartpi.mapper")
public class SmartPiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartPiApplication.class, args);
    }

}
