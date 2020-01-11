package com.lr.concurrent.demo;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liurui
 * @date 2020/1/11 16:14
 */
public class MyLock implements Lock {

    private  boolean flag = false;

    private  int num = 0;

    private  Thread  thread = null;

    @Override
    public synchronized void lock() {

        Thread currentLock = Thread.currentThread();

        /**
         *
         */
        while (flag && thread != currentLock) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flag = true;
        thread = currentLock;
        num++;
    }


    @Override
    public synchronized void unlock() {
        if (thread == Thread.currentThread()) {
            num--;
            if (num == 0) {
                flag = false;
                notify();

            }
        }
    }








    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }



    @NotNull
    @Override
    public Condition newCondition() {
        return null;
    }
}
