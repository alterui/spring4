package com.oyo.car;

/**
 * @author liurui
 * @date 2019/9/24 15:24
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class Solution7 {
    public static void main(String[] args) {

        int reserve = reserve(00);
        System.out.println(reserve);

    }

    public static int reserve(int num) {


        List<Integer> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        if (num < 0) {
            num = -num;
        }
        while (num > 0) {
            int i  =  num%10;
            num = num /10;

            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            //System.out.println();
        }
        if (stringBuilder.toString().equals("")) {
            return 0;
        }

        return Integer.parseInt(stringBuilder.toString());


    }
}
