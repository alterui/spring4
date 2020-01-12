package com.lr.concurrent.producerconsumer;

/**
 * @author liurui
 * @date 2020/1/12 13:46
 */
public class TMall {

    private int num;

    public synchronized void setNum() throws InterruptedException {
        while (num >= 10) {
            System.out.println(Thread.currentThread().getName()+": 仓库数量已满..." );
            wait();
        }
        num++;

        System.out.println("生产者生产，库存数量为:" + num);

        notifyAll();
    }

    public synchronized void getNum() throws InterruptedException {
        while (num <= 0) {
            System.out.println(Thread.currentThread().getName()+": 产品已经售罄....");
            wait();
        }
        num--;

        System.out.println("消费者消费，库存数量为:" + num);
        notifyAll();
    }

}
