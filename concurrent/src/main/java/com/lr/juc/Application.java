package com.lr.juc;

import org.apache.poi.ss.formula.functions.T;
import sun.awt.windows.ThemeReader;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2020/2/26 11:03
 */
public class Application {
    private static volatile int a = 0;

    public static void main(String[] args) {


        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                for (int j = 0; j < 500; j++) {
                    a++;

                }
            }).start();

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(a);



    }

    private static void makeValueSee() {
        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a += 50;
            System.out.println(Thread.currentThread().getName() + ":" + a);
        }, "AAA").start();

        while (a == 0) {

        }
        System.out.println(Thread.currentThread().getName() + ":" + a);
    }
}
