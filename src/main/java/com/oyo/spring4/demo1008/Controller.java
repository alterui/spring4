package com.oyo.spring4.demo1008;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liurui
 * @date 2019/10/8 11:44
 */
@RestController
public class Controller {
    @Autowired
    private APP app;

    @GetMapping("/get")
    public void get() {
        app.get();
    }
}
