package com.oyo.demo.demo1010;

import org.springframework.stereotype.Service;

/**
 * @author liurui
 * @date 2019/10/15 14:54
 */
@Service
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗");
    }
}
