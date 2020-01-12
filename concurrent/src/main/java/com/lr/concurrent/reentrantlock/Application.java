package com.lr.concurrent.reentrantlock;

import com.lr.concurrent.demo.MyLock;

/**
 * @author liurui
 * @date 2020/1/11 12:25
 */
public class Application {

    public static int i = 0;

    // Lock lock = new ReentrantLock();
    MyAQSLock lock = new MyAQSLock();



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
