package com.lr.blog;

import org.apache.poi.ss.formula.functions.T;
import sun.awt.windows.ThemeReader;

import javax.swing.plaf.TableHeaderUI;

/**
 * @author liurui
 * @date 2020/2/4 11:45
 */
public class DeadLockDemo {
    private static Object a = new Object();
    private static Object b = new Object();

    private void getLock() {

        Thread threadA = new Thread(() -> {
            synchronized (a){
                System.out.println("thread1 get a");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("thread1 get b ");
                }

            }
        });


        Thread threadB = new Thread(() -> {
            synchronized (b){
                System.out.println("thread2 get b");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("thread2 get a ");
                }

            }
        });

        threadA.start();
        threadB.start();



    }

    public static void main(String[] args) {
        new DeadLockDemo().getLock();
    }
}

