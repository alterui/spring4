package com.oyo.spring4.demo1008;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.oyo.demo.demo1029.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/10/8 11:42
 */
@Component
public class APP {
    void get() {
        PagedResponse pagedResponse = new PagedResponse(-1, -1, -1L);
        System.out.println(pagedResponse);
    }

    public static void main(String[] args) {
        Student student = new Student(1, "1");
        Student student1 = new Student(1, "1");

        List<Student> studentList = Lists.newArrayList(student,student1);

       // Map<Integer, Student> map = Maps.newHashMap();

        Map<Integer, Student> collect = studentList.stream().collect(Collectors.toMap(Student::getAge, Function.identity()));



    }
}
