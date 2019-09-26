package com.oyo.apply;

import java.util.function.Function;

/**
 * @author liurui
 * @date 2019/9/25 20:32
 */
public class Application extends AbstractFacadeImpl {

    public static int addString(int num) {
        return invoke(num, request -> add(request));
    }

    public static int add(int nums) {
        return nums+nums;
    }

    public static void main(String[] args) {
        int i = addString(10);
        System.out.println(i);
    }

}
