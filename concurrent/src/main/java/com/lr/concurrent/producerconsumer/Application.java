package com.lr.concurrent.producerconsumer;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author liurui
 * @date 2020/1/12 13:54
 */
public class Application {
    public static void main(String[] args) {
        TMall tMall = new TMall();



        new Thread(new Producer(tMall)).start();
        new Thread(new Producer(tMall)).start();
        new Thread(new Producer(tMall)).start();
        new Thread(new Producer(tMall)).start();


        new Thread(new Consumer(tMall)).start();

    }
}
