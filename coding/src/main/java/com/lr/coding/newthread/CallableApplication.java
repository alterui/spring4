package com.lr.coding.newthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liurui
 * @date 2020/1/9 17:42
 */
public class CallableApplication implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("开始计算");

        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //CallableApplication callableApplication = new CallableApplication();
        FutureTask<Integer> task = new FutureTask<>(new CallableApplication());

        Thread thread = new Thread(task);
        thread.start();

        Integer integer = task.get();
        System.out.println(integer);
    }
}
