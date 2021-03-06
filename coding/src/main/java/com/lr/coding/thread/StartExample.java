package com.lr.coding.thread;

/**
 * @author liurui
 * @date 2020/1/9 15:02
 */
public class StartExample {
    private int x = 0;
    private int y = 1;
    private boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        StartExample startExample = new StartExample();

        Thread thread1 = new Thread(startExample::writer, "线程1");
        startExample.x = 10;
        startExample.y = 20;
        startExample.flag = true;

        thread1.start();

        thread1.stop();
        System.out.println("主线程结束");
    }

    public void writer(){
        System.out.println("x:" + x );
        System.out.println("y:" + y );
        System.out.println("flag:" + flag );
    }
}

