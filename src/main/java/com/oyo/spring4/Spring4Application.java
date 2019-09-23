package com.oyo.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Spring4Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring4Application.class, args);
    }

}
