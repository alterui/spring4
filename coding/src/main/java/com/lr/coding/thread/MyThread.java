package com.lr.coding.thread;

/**
 * @author liurui
 * @date 2020/1/4 15:53
 */
public class MyThread {
    public static void main(String[] args)  {
        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
            }).start();

            new Thread(()->{
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
            }).start();
        }




    }
}
