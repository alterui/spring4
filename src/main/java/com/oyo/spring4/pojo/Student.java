package com.oyo.spring4.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author liurui
 * @date 2019/9/3 17:03
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String age;
}
