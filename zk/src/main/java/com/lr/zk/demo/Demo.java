package com.lr.zk.demo;

import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liurui
 * @date 2020/3/3 21:03
 */
public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
