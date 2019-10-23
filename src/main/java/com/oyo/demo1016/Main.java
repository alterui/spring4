package com.oyo.demo1016;

public class Main {
    public static void main(String[] args) {
        Object o = get();
        System.out.println(o);
    }

    public static Object get() {
        String match = "[^\\u4e00-\\u9fa5]+";
        String string = "[0-9]{4}[-][0-9]{2}[-][0-9]{2}[~][0-9]{4}[-][0-9]{2}[-][0-9]{2}";


        boolean matches = "2019-08-07~2019-08-08".matches(string);
        return matches;

    }
}
