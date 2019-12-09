package com.oyo.jvm;

import com.oyo.demo.demo1029.Student;
import org.apache.catalina.User;

/**
 * @author liurui
 * @date 2019/12/9 15:00
 */



public class Math {
    public static int initData = 666;
    public static Student user = new Student();
    public int compute(){
        int a =1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
        System.out.println("test");
    }
}
