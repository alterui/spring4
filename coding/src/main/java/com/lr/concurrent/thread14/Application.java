package com.lr.concurrent.thread14;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author liurui
 * @date 2020/1/11 11:25
 */
public class Application {
    public static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }

            flag = true;
        }).start();

        new Thread(()->{
            while (!flag) {

            }
            System.out.println("线程2开始执行了.....");
        }).start();
    }
}
