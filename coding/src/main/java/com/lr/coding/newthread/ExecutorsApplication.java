package com.lr.coding.newthread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liurui
 * @date 2020/1/9 19:11
 */
public class ExecutorsApplication {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(()-> System.out.println(Thread.currentThread().getName()));
        }


        executorService.shutdown();

    }
}
