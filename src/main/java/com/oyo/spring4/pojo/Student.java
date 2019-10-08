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
//@AllArgsConstructor
public class Student extends Person{
    //@NotBlank(message = "NotBlack起作用")
    private String name ;
    private String age ;

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("1");
        student.setAge("22");

        Student student1 = new Student();

       // BeanUtils.copyProperties(student, student1);

        student1 = student;

        student1.setAge("55555");
        student1.setName("55555555");

        System.out.println(student1);

        System.out.println(student);
    }
}
