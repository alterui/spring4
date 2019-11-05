package com.oyo.spring4.controller.dto;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/11/5 16:24
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> collect = list.stream().filter(e -> e > 1 && e.equals(2)).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
