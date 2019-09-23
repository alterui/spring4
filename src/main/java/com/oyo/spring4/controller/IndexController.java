package com.oyo.spring4.controller;

import com.oyo.spring4.application.CountNum;
import com.oyo.spring4.integration.CompactDisc;
import com.oyo.spring4.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liurui
 * @date 2019/8/28 18:27
 */
@RestController
public class IndexController {

    @Value("${name}")
    private String name;

    @Resource(name = "getStudent")
    private Student student;

    @Autowired
    @Qualifier("getStudents")
    private Student student1;

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    CountNum countNum;

    @RequestMapping("/")
    public String index() throws InterruptedException {
        countNum.getWords();
        Thread.sleep(500);
        System.out.println("我在吃饭");

        return student.toString()+student1.toString();
    }
}
