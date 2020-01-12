package com.lr.concurrent.producerconsumer;

import lombok.SneakyThrows;

/**
 * @author liurui
 * @date 2020/1/12 13:50
 */
public class Producer implements Runnable {

    private TMall tMall;

    public Producer(TMall tMall) {
        this.tMall = tMall;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            tMall.setNum();
            Thread.sleep(1000);
        }
    }
}
