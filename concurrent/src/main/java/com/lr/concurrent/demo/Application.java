package com.lr.concurrent.demo;

import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.A;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/1/11 12:25
 */
public class Application {

    public static int i = 0;

    Lock lock = new ReentrantLock();


    public int getNextValue() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        int result = 0;
        try {
            result = i++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    public static void main(String[] args) {
        Application application = new Application();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(application.getNextValue());
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(application.getNextValue());
            }
        }).start();
    }
}
