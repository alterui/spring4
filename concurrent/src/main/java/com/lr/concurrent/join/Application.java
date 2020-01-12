package com.lr.concurrent.join;

import org.checkerframework.checker.units.qual.A;

/**
 * @author liurui
 * @date 2020/1/12 19:19
 */
public class Application {
    public void a(Thread thread) {
        System.out.println("主线程正在执行.....");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕...");
    }

    public void b(){
        System.out.println("加塞线程正在执行....");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("加塞线程执行完毕");
    }

    public static void main(String[] args) {
        Application application = new Application();

        Thread thread = new Thread(() -> {
            application.b();
        });

        new Thread(()->{
            application.a(thread);

        }).start();
    }
}
