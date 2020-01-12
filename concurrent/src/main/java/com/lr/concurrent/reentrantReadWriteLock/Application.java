package com.lr.concurrent.reentrantReadWriteLock;

/**
 * @author liurui
 * @date 2020/1/12 11:25
 */
public class Application {
    public static void main(String[] args) {
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
//
//        new Thread(()->{
//            myReadWriteLock.setValue(23, 12);
//        }).start();
//
//        new Thread(()->{
//            myReadWriteLock.setValue(25, 12);
//        }).start();

        myReadWriteLock.setValue(23, 2);



        new Thread(()->{
            myReadWriteLock.getValue(23);
        }).start();

        new Thread(()->{
            myReadWriteLock.getValue(23);
        }).start();

        new Thread(()->{
            myReadWriteLock.getValue(23);
        }).start();


        new Thread(()->{
            myReadWriteLock.getValue(23);
        }).start();


        new Thread(()->{
            myReadWriteLock.getValue(23);
        }).start();



    }
}
