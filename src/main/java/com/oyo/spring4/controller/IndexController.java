package com.oyo.spring4.controller;

import com.oyo.spring4.application.CountNum;
import com.oyo.spring4.integration.CompactDisc;
import com.oyo.spring4.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @PostMapping("/")
    public String index(@Valid @RequestBody Student student, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                return error.getDefaultMessage();
            }
        }
        return student.toString();
    }
}
