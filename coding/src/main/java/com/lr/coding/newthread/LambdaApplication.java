package com.lr.coding.newthread;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @author liurui
 * @date 2020/1/9 19:38
 */
public class LambdaApplication {
    public static void main(String[] args) {
       /* String json = "{\n" +
                "    \"age\",\n" +
                "    \"name\":\"tom\"\n" +
                "}";*/

        Student student = new Student();
        student.setAge(11);
        student.setName("tom");

        System.out.println(student.toString());


        Student student1 = JSON.parseObject(JSON.toJSON(student).toString(), Student.class);


        System.out.println(student1);
    }

    public int add(List<Integer> list) {
       return list.parallelStream().mapToInt(e->e).sum();

    }
}
