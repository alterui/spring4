package com.oyo.demo.demo1016;

import com.alibaba.fastjson.JSON;

public class JsonParse {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"name\":\"liu\"\n" +
                "}";

        String json2 = "{\n" +
                "    \"naqme\":\"liu\",\n" +
                "    \"age\":\"22\"\n" +
                "}";
        Student student = JSON.parseObject(json2, Student.class);

        System.out.println(student);
    }
}
