package com.oyo.demo.demo1023;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("请输入数组串(例如：12312334):");
        //键盘获取的值，比如1231321231
        String value = input.next();

        //将2342342，拆分成{2,3,4,2,3,4,2}
        String[] split = value.split("");

        //将string[]数组转化为int[]类型
        int[] nums = new int[split.length];
        for (int j = 0; j < split.length; j++) {
            nums[j] = Integer.parseInt(split[j]);
        }

        //用于记录结果数组的位置
        int z = 0;

        //用于盛放结果
        int[] result = new int[nums.length];
        int count = nums.length;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (nums[i] != result[j]) {
                    count--;
                }else {
                    //如果相等，则跳出本层循环
                    break;
                }
                //表明从第一个值到最后都没有重复的值
                if (count == 0) {
                    //为结果数组赋值
                    result[z++] = nums[i];
                    //count重置
                    count=nums.length;
                }
            }
        }

        //遍历输出结构，注意只遍历到z，因为初始化数组长度后，默认值为0
        System.out.print("去除重复的结果为:");
        for (int i = 0; i < z; i++) {
            System.out.print(result[i]);

        }


    }
}
