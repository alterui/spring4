package com.lr.concurrent.condition;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/1/12 15:01
 */
public class Application {

    /**
     * 使用signal以此来控制输出的顺序
     * wait()和notifyALl()方法要在锁里面执行，因此在方法体上添加synchronized关键字
     * notifyAll是唤醒所有在wait()状态中的线程，而notify方法则是随机唤醒在wait状态中的某一个线程
     */
    private int signal;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();


    public  void a() {
        lock.lock();
        while (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        ++signal;
        b.signal();
       lock.unlock();
    }

    public  void b() {
        lock.lock();
        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        ++signal;
        c.signal();

        lock.unlock();

    }

    public synchronized void c() {
        lock.lock();
        while (signal != 2) {
            try {
               c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();

    }



    public static void main(String[] args) {
        Application application = new Application();
        A a = new A(application);
        B b = new B(application);
        C c = new C(application);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }

}


class A implements Runnable {

    /**
     * 这样写的好处很多，通过该类的构造参数将其他类的对象传送进来，保证对象的统一性。
     */
    private Application application;

    public A(Application a) {
        this.application = a;
    }
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            application.a();
            Thread.sleep(500);
        }
    }
}

class B implements Runnable {
    private Application application;

    public B(Application a) {
        this.application = a;
    }
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            application.b();
            Thread.sleep(500);
        }
    }
}

class C implements Runnable {
    private Application application;

    public C(Application a) {
        this.application = a;
    }
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            application.c();
            Thread.sleep(500);
        }
    }
}

