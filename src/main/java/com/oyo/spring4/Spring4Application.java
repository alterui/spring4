package com.oyo.spring4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@MapperScan("com.oyo.spring4.mapper.CountryMapper")
@MapperScan(value = {"com.oyo.spring4.mapper"})

public class Spring4Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring4Application.class, args);
    }

}
