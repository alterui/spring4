package com.lr.coding.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * @author liurui
 * @date 2020/1/4 16:59
 */
public class MyExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(() -> {
            int num = 0;
            for (int i = 0; i < 10; i++) {
                num += i;
            }
            return num;
        });
        Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();

        Thread thread = new Thread();
        thread.setPriority(10);
        Thread.yield();

    }
}
