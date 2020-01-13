package com.lr.concurrent.futuretask;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liurui
 * @date 2020/1/13 14:53
 */
public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> integerCallable = () -> {
            Thread.sleep(300);
            return 1;

        };

        FutureTask futureTask = new FutureTask(integerCallable);

        new Thread(futureTask).start();


        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(futureTask.get());

    }
}
