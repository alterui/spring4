package com.lr.coding.thread01;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liurui
 * @date 2020/1/10 22:27
 */
public class HungryApplication {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + ":" + SingletonHungry.getInstance());
            });
        }

        //close

        executorService.shutdown();
    }
}
