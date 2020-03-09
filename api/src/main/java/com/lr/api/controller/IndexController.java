package com.lr.api.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liurui
 * @date 2020/3/9 22:13
 */
@RestController
public class IndexController {

    @RequestMapping("/hi")

    public String getIndex() {

        get();
        return "hello world";
    }

    @Transactional
    public void get() {

        System.out.println("======================================================");
        int i = 9 / 0;
    }

}
