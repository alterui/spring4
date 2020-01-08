package com.oyo.thread;

/**
 * @author liurui
 * @date 2020/1/4 12:54
 */
public class Test {

    public synchronized void test1() {

    }

    public void test2() {
        synchronized (this) {

        }
    }

}
