package com.lr.coding.thread;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.*;

/**
 * @author liurui
 * @date 2020/1/4 16:38
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        int num = 0;

        for (int i = 0; i < 10; i++) {
            num += i;
        }
        return num;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        new Thread(futureTask).start();
        String name = Thread.currentThread().getName();
        System.out.println(name);

        int i  =  futureTask.get();
        System.out.println(i);

    }
}
