package com.lizhenfang.lizhenfangday01.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyBatisConfig {
    @Bean
    public PaginationInterceptor page(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        return  paginationInterceptor;
    }
}
