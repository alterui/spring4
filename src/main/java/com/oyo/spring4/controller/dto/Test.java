package com.oyo.spring4.controller.dto;

import com.alibaba.fastjson.JSON;
import com.oyo.demo.demo1029.Student;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/11/5 16:24
 */
public class Test {
    public static void main(String[] args) {
        String str = "12;12;12,1231,11,123123123213123,12";
        String match = "([0-9]+[,|;]?)*[0-9]";
        boolean matches = str.matches(match);
        if (!matches) {
            System.out.println("false");
        }

        Student student = new Student(1, "a");
        Student student1 = new Student(1, "a");

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);

        //Set<Student> collect = new HashSet<>(list);

       // collect.forEach(System.out::println);


        Map<Integer, String> collect = list.stream().distinct().collect(Collectors.toMap(Student::getAge, Student::getName));

        collect.forEach((k,v)->{
            System.out.println(k);
        });
//        Map<Integer, String> result = Maps.newHashMap();
//        map.forEach((k,v)->{
//            if (!CollectionUtils.isEmpty(v)) {
//                Student student2 = v.get(0);
//                result.put(student2.getAge(), student2.getName());
//            }
//
//        });

        String string = "2";
        String string1 = "2";

        if (StringUtils.isEmpty(string) || StringUtils.isEmpty(string1)) {
            System.out.println("11");
        } else {
            if (string == string1) {

                System.out.println("22");
            }
        }


        Student student2 = new Student(1,"1");
        Student student3 = new Student(1, "1");
        System.out.println(student2.getName()==student3.getName());

        student2 = JSON.parseObject(JSON.toJSONString(student2), Student.class);
        student2 = JSON.parseObject(JSON.toJSONString(student2), Student.class);
        System.out.println(student2.getName()==student2.getName());


    }
}
