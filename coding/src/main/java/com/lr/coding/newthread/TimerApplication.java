package com.lr.coding.newthread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liurui
 * @date 2020/1/9 19:21
 */
public class TimerApplication {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("计时器"+Thread.currentThread().getName());
            }
        },0,1000);
    }
}
