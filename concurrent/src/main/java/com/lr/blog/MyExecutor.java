package com.lr.blog;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author liurui
 * @date 2020/2/4 16:31
 */
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> submit = executorService.submit(() -> {
            return 1;
        });

        try {
            Integer integer = submit.get();
            System.out.println(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
