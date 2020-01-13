package com.lr.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author liurui
 * @date 2020/1/13 14:06
 */
public class Application {

    public void get(Semaphore semaphore) {
        try {
            semaphore.acquire();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" is run...");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }



    public static void main(String[] args) {
        Application application = new Application();

        Semaphore semaphore = new Semaphore(10);

        while (true) {
            new Thread(()->{
                application.get(semaphore);

            }).start();
        }
    }
}
