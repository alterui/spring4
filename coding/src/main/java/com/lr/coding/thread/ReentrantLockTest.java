package com.lr.coding.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/1/6 21:06
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            reentrantLock.lock();
        }


        for (int i = 0; i < 3; i++) {
            reentrantLock.unlock();
        }
    }


}
