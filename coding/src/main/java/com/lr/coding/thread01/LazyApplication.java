package com.lr.coding.thread01;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liurui
 * @date 2020/1/10 22:11
 */
public class LazyApplication {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(()-> System.out.println(Thread.currentThread().getName()+": "+SingletonLazy.getInstance()));
        }


        executorService.shutdown();
    }
}
