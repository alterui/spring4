package com.oyo.spring4.facade;

import com.oyo.spring4.client.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author liurui
 * @date 2019/10/15 15:11
 */
@Service
@Primary
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗");
    }
}
