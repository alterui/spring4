package com.lr.concurrent.exchanger;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.Exchanger;

/**
 * @author liurui
 * @date 2020/1/13 14:30
 */
public class Application {

    public void a(Exchanger<String> exchanger) {
        System.out.println("a方法开始执行....");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = "12345";

        try {
            String exchange = exchanger.exchange(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void b(Exchanger<String> exchanger) {
        System.out.println("b方法开始执行....");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = "12345";

        try {
            String exchange = exchanger.exchange(result);

            System.out.println("开始进行比对..");

            System.out.println("比对结果为："+ exchange.equals(result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application application = new Application();

        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            application.a(exchanger);

        }).start();

        new Thread(()->{
            application.b(exchanger);

        }).start();
    }
}
