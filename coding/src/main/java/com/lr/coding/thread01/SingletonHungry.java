package com.lr.coding.thread01;

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
