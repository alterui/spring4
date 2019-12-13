package com.oyo.map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liurui
 * @date 2019/12/11 11:37
 */
public class HashMapApplication {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();

        map.put("name", "rui");

        Class<? extends Map> mapType = map.getClass();

        Method capacity = mapType.getDeclaredMethod("capacity");

        capacity.setAccessible(true);
        System.out.println("capacity:" + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size:" + size.get(map));

        int i= 3&2;
        System.out.println(i);

        int i1 = map.hashCode();
        System.out.println(i1);

        byte a = 122;

        int b = a ;

        System.out.println(b);
    }
}
