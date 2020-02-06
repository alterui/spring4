package com.lr.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2020/2/5 19:12
 */
public class Demo {
    public static void main(String[] args) {
        String a = "abc";
        char c = a.charAt(0);
        System.out.println((int)c);
    }

}