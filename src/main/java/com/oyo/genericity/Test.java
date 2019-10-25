package com.oyo.genericity;

import com.google.common.collect.Lists;
import com.oyo.spring4.pojo.Student;

import java.util.List;

public class Test {

    public static <T> void show1(List<T> list) {
        for (Object object : list) {
            System.out.println(object.toString());
        }
    }

    public static void show2(List<?> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Student> list1 = Lists.newArrayList();
        list1.add(new Student("张三", "22"));
        list1.add(new Student("李四", "23"));
        list1.add(new Student("王五", "24"));

        show1(list1);
        System.out.println("=========================分割线========================");


        List<?> list = Lists.newArrayList();




    }
}
