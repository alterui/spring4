package com.application;

import com.oyo.demo.demo1029.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author liurui
 * @date 2019/12/30 20:12
 */
public class Application {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student(4, "张三"));
        list.add(new Student(7, "李四"));
        list.add(new Student(1, "王五"));
        list.add(new Student(5, "刘六"));

        list.sort(Comparator.comparingLong(Student::getAge));

        list.forEach(System.out::println);
    }
}
