package com.lr.concurrent.countdownlatch;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liurui
 * @date 2020/1/12 21:39
 */
public class Application {


    //用于存放结果
    private int[] nums ;

    /**
     * 对于size而言是一个未知的数据，可以通过构造方法传进来，这个是一个很好的设计。
     * @param size
     */
    public Application(int size) {
        nums = new int[size];
    }

    /**
     * 计算每行读取的值，进行计算方法nums[]数组里面
     * @param line
     * @param index
     */
    private void calculator(String line, int index,CountDownLatch countDownLatch) {
        System.out.println(Thread.currentThread().getName()+" 计算开始....");
        String[] split = line.split(",");

        int total = 0;
        for (String num : split) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 计算结束,line为：" + line + "，计算结果为： " + total);
        countDownLatch.countDown();
    }

    /**
     * 这里分开写的原因是等读取的数字完成后，再把每组的数字累加起来
     */
    private void getSum() {

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        System.out.println("计算的总结果为："+ total);
    }




    public static void main(String[] args)   {


        List<String> list = Lists.newArrayList();


        List<String> lineList = readFile(list);

        CountDownLatch countDownLatch = new CountDownLatch(lineList.size());


        Application application = new Application(list.size());

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            new Thread(()->{
                application.calculator(list.get(finalI), finalI,countDownLatch);
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        application.getSum();
    }

    private static List<String> readFile(List<String> list) {
        String line;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("E://num.txt"));


            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
