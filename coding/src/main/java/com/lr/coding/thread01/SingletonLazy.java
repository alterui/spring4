package com.lr.coding.thread01;

/**
 * @author liurui
 * @date 2020/1/10 22:20
 */
public class SingletonLazy {
    private SingletonLazy(){}

    private static volatile SingletonLazy singletonLazy;

    public static  SingletonLazy getInstance()  {
        if (singletonLazy == null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (SingletonLazy.class) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy();
                }
            }

        }

        return singletonLazy;
    }
}
