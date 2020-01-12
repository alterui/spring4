package com.lr.concurrent.signal;

import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;

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

    public synchronized void a() {
        while (signal != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        ++signal;
        notifyAll();
    }

    public synchronized void b() {
        while (signal != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        ++signal;
        notifyAll();

    }

    public synchronized void c() {
        while (signal != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        notifyAll();

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

