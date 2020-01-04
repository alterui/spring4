package com.oyo.thread;

/**
 * @author liurui
 * @date 2019/12/29 16:11
 */
public  class SynchronizedApplication {

    private static int j;

    public static  void main(String[] args) throws InterruptedException {


        for (int k = 0; k < 10; k++) {
            new Thread(() ->{
                for (int i = 0; i < 10; i++) {
                    add();
                }
            }).start();
        }
        //sleep的作用是为了让其他线程获取cup执行的机会
        Thread.sleep(1000);

        System.out.println(j);
    }

    public static synchronized int add() {
        return ++j;
    }
}
