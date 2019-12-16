package com.oyo.java3y;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2019/12/16 14:48
 */
public class AtomicMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Count count = new Count();
        for (int i = 0; i < 100; i++) {
            service.execute(count::increase);
        }

        service.shutdown();
        boolean flag = service.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(flag);


        System.out.println(count.getCount());
    }
}

class Count {
    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public synchronized void increase() {
        count++;
    }
}
