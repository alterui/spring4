package com.oyo.demo1016;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<String> list = Lists.newArrayList();
        String a = "--";
        String b = "2";

        list.add(a);
        list.add(b);

        int i ;


        try {
            i = Integer.parseInt(list.get(0));
            System.out.println("第一次");
        } catch (NumberFormatException e) {
            System.out.println("第二次");
            i = Integer.parseInt(list.get(list.size()-1));
        }

        System.out.println(i);

    }
}
