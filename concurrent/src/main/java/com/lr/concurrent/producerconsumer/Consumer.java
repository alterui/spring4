package com.lr.concurrent.producerconsumer;

import lombok.SneakyThrows;

/**
 * @author liurui
 * @date 2020/1/12 13:53
 */
public class Consumer implements Runnable {

    private TMall tMall;

    public Consumer(TMall tMall) {
        this.tMall = tMall;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            tMall.getNum();

            Thread.sleep(1000);
        }
    }
}
