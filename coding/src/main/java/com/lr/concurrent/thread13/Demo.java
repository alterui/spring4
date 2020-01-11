package com.lr.concurrent.thread13;

/**
 * @author liurui
 * @date 2020/1/11 10:51
 */
public class Demo {

    Object object1 = new Object();
    Object object2 = new Object();

    public void a() {
        synchronized (object1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (object2) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();


        new Thread(()->{
            demo.a();

        }).start();


        new Thread(()->{
            demo.b();

        }).start();

    }
}
