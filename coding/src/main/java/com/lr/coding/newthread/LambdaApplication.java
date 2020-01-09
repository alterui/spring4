package com.lr.coding.newthread;

import java.util.Arrays;
import java.util.List;

/**
 * @author liurui
 * @date 2020/1/9 19:38
 */
public class LambdaApplication {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int add = new LambdaApplication().add(list);
        System.out.println(add);
    }

    public int add(List<Integer> list) {
       return list.parallelStream().mapToInt(e->e).sum();

    }
}
