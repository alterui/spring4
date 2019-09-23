package com.oyo.spring4.application;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liurui
 * @date 2019/9/17 20:25
 */
@Component
public class CountNum {
   @Async
    public void getWords() throws InterruptedException {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(1000);
                System.out.println("第"+i+"次问你:你在干嘛？");
            }

    }

}
