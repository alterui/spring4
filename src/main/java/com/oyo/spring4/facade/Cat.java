package com.oyo.spring4.facade;

import com.oyo.spring4.client.*;
import org.springframework.stereotype.Service;

/**
 * @author
 * @date 2019/10/15 15:15
 */
@Service
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫");
    }
}
