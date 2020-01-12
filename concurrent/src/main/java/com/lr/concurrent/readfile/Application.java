package com.lr.concurrent.readfile;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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
    private void calculator(String line, int index) {
        System.out.println(Thread.currentThread().getName()+" 计算开始....");
        String[] split = line.split(",");

        int total = 0;
        for (String num : split) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName()+" 计算结束,line为："+line+"，计算结果为： "+total);
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




    public static void main(String[] args) throws Exception {


        List<String> list = Lists.newArrayList();


        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E://num.txt"));


        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }

        Application application = new Application(list.size());

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            new Thread(()->{
                application.calculator(list.get(finalI), finalI);
            }).start();
        }

        /**
         * 等待所有线程执行结束
         */
        while (Thread.activeCount() != 1) {

        }

        application.getSum();
    }
}
