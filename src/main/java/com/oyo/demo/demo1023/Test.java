package com.oyo.demo.demo1023;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("我");
        list.add("们");

        list.clear();

        list.forEach(System.out::println);
    }
}
