package com.oyo.demo1024;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("A", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        items.put("G", 70);

        //items.forEach((k, v) -> System.out.println("item:" + k + "count:" + v));
        items.forEach((k,v)->{
            System.out.println(k+":"+v);

        });





    }
}
