package com.oyo.spring4.controller.dto;

import com.oyo.demo.demo1029.Student;

/**
 * @author liurui
 * @date 2019/11/13 21:00
 */
public class Application {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("1");

        Help help = new Help();
        help.setValue("1");

        System.out.println(student.getName()==help.getValue());
    }
}
