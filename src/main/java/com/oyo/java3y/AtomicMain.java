package com.oyo.java3y;

import com.alibaba.excel.util.DateUtils;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liurui
 * @date 2019/12/16 14:48
 */
public class AtomicMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();


        String format = DateUtils.format(new Date(), DateUtils.DATE_FORMAT_19);
        System.out.println(format);
        Count count = new Count();
        for (int i = 0; i < 100; i++) {
            service.execute(count::increase);
        }

        Integer i   = null;


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");






        service.shutdown();
        boolean flag = service.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(flag);


        System.out.println(count.getCount());
    }
}

class Count {
    private AtomicInteger count = new AtomicInteger(0);

    public Integer getCount() {
        return count.get();
    }

    public  void increase() {
        count.incrementAndGet();
    }
}
