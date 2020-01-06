package com.lr.coding.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/1/5 16:45
 */
public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread  thread  = new Thread(() -> {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("finally block");
                }

            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);

        ReentrantLock reentrantLock = new ReentrantLock();
    }
}
