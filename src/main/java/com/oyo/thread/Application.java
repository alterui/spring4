package com.oyo.thread;

/**
 * @author liurui
 * @date 2019/12/29 16:11
 */
public class Application {
    private static volatile  boolean flag = false;
    public static void main(String[] args) throws Exception {



        new Thread(()->{
            while (!flag){

            }
            System.out.println("end========");
        }).start();

        Thread.sleep(100);

        new Thread(()->{
            System.out.println("start");
            flag = true;
            System.out.println("end");
        }).start();


    }
}
