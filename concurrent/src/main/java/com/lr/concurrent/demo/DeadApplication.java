package com.lr.concurrent.demo;

/**
 * @author liurui
 * @date 2020/1/11 16:52
 */
public class DeadApplication {

    MyLock lock = new MyLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        DeadApplication application = new DeadApplication();

        new Thread(() -> {

            application.a();

        }).start();
    }
}
