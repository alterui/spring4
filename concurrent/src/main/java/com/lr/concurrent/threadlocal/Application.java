package com.lr.concurrent.threadlocal;

import org.checkerframework.checker.units.qual.A;

/**
 * @author liurui
 * @date 2020/1/12 20:03
 */
public class Application {

    //初始化ThreadLocal的初始值
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public int getNext() {

        Integer value = threadLocal.get();
        value++;
        threadLocal.set(value);
        return value;


    }
    public static void main(String[] args) {

        Application application = new Application();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+": "+application.getNext());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();






    }
}
