package com.oyo.demo1029;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/10/29 19:07
 */
public class Application {
    public static void main(String[] args) {
        Student student = new Student(11, "name");
        Student student1 = new Student(12, null);

        List<Student> studentList = Lists.newArrayList();

        studentList.get(0);

        studentList.add(student);
        studentList.add(student1);
        Map<Integer, String> collect = studentList.stream().collect(Collectors.toMap(Student::getAge, Student::getName));

        System.out.println(collect.get(11));


    }
}
