package com.oyo.demo.demo0926;

import java.util.function.Function;

/**
 * @author liurui
 * @date 2019/9/26 10:41
 */
public class Test {
    public static void main(String[] args) {
        Function<String,String> function = String::toUpperCase;

        String value = function.apply("abc");

        System.out.println(value);


        
    }

}
