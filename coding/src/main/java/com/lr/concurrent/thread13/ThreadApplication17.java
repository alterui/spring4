package com.lr.concurrent.thread13;

import org.apache.poi.ss.formula.functions.T;

import java.util.Random;

/**
 * @author liurui
 * @date 2020/1/11 10:12
 */
public class ThreadApplication17 {
    public static void main(String[] args) {


        new Thread(()->{
            System.out.println("线程开始执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕了");

        }).start();


        new Thread(()->{
            System.out.println("线程开始执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕了");

        }).start();

        new Thread(()->{
            System.out.println("线程开始执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕了");

        }).start();



        while (Thread.activeCount() != 1) {

            System.out.println(Thread.activeCount());
        }

        System.out.println("线程执行完毕了....");

    }
}
