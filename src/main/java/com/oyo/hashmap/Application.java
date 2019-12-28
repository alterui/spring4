package com.oyo.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author liurui
 * @date 2019/12/27 16:40
 */
public class Application {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(3);

        Collections.sort(list);

        list.forEach(System.out::println);

    }
}
