package com.lr.coding.newthread;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author liurui
 * @date 2020/1/9 16:28
 */
public class ThreadApplication extends Thread{
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName()+"执行了.....");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadApplication thread = new ThreadApplication();


        thread.start();

        System.out.println(thread.isInterrupted());
        Thread.sleep(2000);
        thread.interrupt();


    }
}
