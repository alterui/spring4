package com.oyo.spring4.controller;

import com.oyo.spring4.integration.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liurui
 * @date 2019/8/28 18:27
 */
@RestController
public class IndexController {

    @Value("${name}")
    private String name;

    @Autowired
    private CompactDisc compactDisc;

    @RequestMapping("/")
    public String index() {
        return name;
    }
}
