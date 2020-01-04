package com.lr.coding.thread;

import lombok.SneakyThrows;

/**
 * @author liurui
 * @date 2020/1/4 16:04
 */
public class ThreadApplication extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {


            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadApplication application = new ThreadApplication();
        application.start();
        Thread.sleep(100);

        ThreadApplication application1 = new ThreadApplication();
        application1.start();
    }
}
