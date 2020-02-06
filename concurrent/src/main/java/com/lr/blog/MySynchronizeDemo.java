package com.lr.blog;

/**
 * @author liurui
 * @date 2020/2/4 17:51
 */
public class MySynchronizeDemo {
    static  int i = 0;
    public static synchronized void test1() {
        System.out.println(Thread.currentThread().getName()+":"+i++);

    }

    public    synchronized void test2() {
        synchronized (MySynchronizeDemo.class) {
            System.out.println(Thread.currentThread().getName()+":"+i++);

        }

    }


    public static void main(String[] args) {
        MySynchronizeDemo demo = new MySynchronizeDemo();
        MySynchronizeDemo demo1 = new MySynchronizeDemo();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo.test1();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demo.test2();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
