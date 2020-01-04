package com.lr.coding.thread;

/**
 * @author liurui
 * @date 2020/1/4 13:39
 */

import lombok.Data;

/**
 * 父类
 */
@Data
public class ThreadParentTest {
    public synchronized void doSomething() {
        System.out.println(toString() +": parent doSomething ");
    }

    public static void main(String[] args) {
        ThreadChildTest threadChildTest = new ThreadChildTest();
        threadChildTest.doSomething();

    }
}

/**
 * 子类
 */
@Data
class ThreadChildTest extends ThreadParentTest {

    public synchronized void doSomething() {
        System.out.println(toString() + ": child doSomething");
        super.doSomething();
    }
}

