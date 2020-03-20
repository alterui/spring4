package com.lr.api.configation;

import com.lr.api.annotation.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liurui
 * @date 2020/3/18 13:53
 */
@Configuration
public class StudentBean {
    @Bean
    public Student getStudent() {
        return new Student(1, "gg");
    }
}
