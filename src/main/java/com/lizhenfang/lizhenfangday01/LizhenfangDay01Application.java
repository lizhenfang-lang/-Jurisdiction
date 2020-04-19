package com.lizhenfang.lizhenfangday01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lizhenfang.lizhenfangday01.mapper")
public class LizhenfangDay01Application {

    public static void main(String[] args) {
        SpringApplication.run(LizhenfangDay01Application.class, args);
    }

}
