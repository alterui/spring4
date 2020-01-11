package com.lr.concurrent.thread13;

/**
 * @author liurui
 * @date 2020/1/11 9:54
 */
public class ThreadApplication {
    public synchronized void a() {
        System.out.println("a");
        b();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThreadApplication application = new ThreadApplication();
        new Thread(()->{
            application.a();
        }).start();

        new Thread(()->{
            application.b();
        }).start();

    }
}

