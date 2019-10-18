package com.oyo.demo1016;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        List<Student> studentList = Lists.newArrayList();
        studentList.add(new Student("tom", "上海"));
        studentList.add(new Student("ab", "南京"));
        studentList.add(null);

        studentList = studentList.stream().filter(student -> {
            if (student != null) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());

        studentList.forEach(System.out::println);
    }
}
