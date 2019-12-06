package com.oyo.spring4.service.impl;

import com.oyo.spring4.service.RedisService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liurui
 * @date 2019/12/6 18:03
 */

@Service
public class MyThread implements Runnable {
    @Resource
    private RedisService redisService;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            redisService.delete();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {

            }
            redisService.update();
        }
    }
}
