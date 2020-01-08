package com.lr.coding.thread;

import lombok.SneakyThrows;

/**
 * @author liurui
 * @date 2020/1/4 16:08
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);

        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread2.start();


       thread1.interrupt();
        Thread.yield();
       while (thread1.isInterrupted());
       System.out.println(thread1.isInterrupted());



    }
}
