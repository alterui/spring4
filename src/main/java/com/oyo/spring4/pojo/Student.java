package com.oyo.spring4.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liurui
 * @date 2019/9/3 17:03
 */
@Data
@AllArgsConstructor
public class Student extends Person{
    //@NotBlank(message = "NotBlack起作用")
    private String name ;
    private String age ;


}
