package com.oyo.demo1016;

public class Main {
    public static void main(String[] args) {
        Object o = get();
        System.out.println(o);
    }

    public static Object get() {
        String match = "[^\\u4e00-\\u9fa5]+";

        boolean matches = "2313123211221e123412".matches(match);
        if (!matches) {
            return "有中文";
        }
        return "没有中文";
    }
}
