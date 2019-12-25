package com.oyo.java3y;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2019/12/17 10:53
 */
public class RateLimiterTest {
    public static void main(String[] args) throws InterruptedException {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //速度是每秒只有3个许可
        final RateLimiter rateLimiter = RateLimiter.create(3.0);

        for (int i = 0; i < 100; i++) {
            final int no  = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //获得许可
                    rateLimiter.acquire();
                    System.out.println("Accessing:" + no + ",time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

                }
            };

            exec.execute(runnable);
            //exec.shutdown();
            boolean b = exec.awaitTermination(1l, TimeUnit.MICROSECONDS);
            System.out.println(b);




        }
    }
}
