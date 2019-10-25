package com.oyo.demo1024;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Test  {
    public static void main(String[] args) {
        List<String> putAway = Lists.newArrayList();
        putAway.add("美团");
        putAway.add("携程");

        List<String> all = Lists.newArrayList();
        all.add("美团");
        all.add("携程");
        all.add("艺龙");
        all.add("飞猪");


        List<String> c = all.stream().filter(e -> !putAway.contains(e)).collect(Collectors.toList());

        c.forEach(System.out::println);

    }
}
