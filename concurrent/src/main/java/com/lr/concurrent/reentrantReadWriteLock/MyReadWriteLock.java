package com.lr.concurrent.reentrantReadWriteLock;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liurui
 * @date 2020/1/12 11:06
 */
public class MyReadWriteLock {

    ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    Map<Integer, Integer> hashMap = Maps.newHashMap();

    public void setValue(int key, int value) {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + ": 写操作正在进行....");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            hashMap.put(key, value);
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+": 写操作已经完成....");
        }
    }

    public void getValue(int key) {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + ": 读操作正在进行....");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            hashMap.get(key);
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+": 读操作已经完成....");
        }
    }

    public static void main(String[] args) {


    }
}
