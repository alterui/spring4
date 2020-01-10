package com.lr.concurrent.thread13;

/**
 * @author liurui
 * @date 2020/1/10 22:09
 */
public class SingletonHungry {
    private SingletonHungry(){}

    private static SingletonHungry singletonHungry = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return singletonHungry;
    }
}
