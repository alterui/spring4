package com.lr.coding.threadlocal;

/**
 * @author liurui
 * @date 2020/1/6 23:02
 */
public class ThreadLocalApplication {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        o.wait();

        ThreadLocal<String> localName = new ThreadLocal<>();

        localName.set("lr");

        String name = localName.get();

        System.out.println(name);



    }
}
