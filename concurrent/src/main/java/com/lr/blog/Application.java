package com.lr.blog;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liurui
 * @date 2020/2/9 22:03
 */
public class Application {
    private void add(int a, int b) {
        System.out.println(a+b);
    }

    public int add(int a ,int b,int c){
        return a+b+c;
    }
}
