package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.oyo.demo1010.HotelPublishRequestDto;
import com.oyo.spring4.application.CountNum;
import com.oyo.spring4.integration.CompactDisc;
import com.oyo.spring4.pojo.Student;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class IndexController {

    @Value("${name}")
    private String name;

   // @Resource(name = "getStudent")
    //private Student student;

   // @Autowired
   // @Qualifier("getStudents")
    //private Student student1;

   // @Autowired
    private CompactDisc compactDisc;

    @Autowired
    CountNum countNum;

    @PostMapping("/")
    public String index(@Valid @RequestBody Student student, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                log.info("IndexController#index param is={}", result);
                return error.getDefaultMessage();
            }
        }
        return student.toString();
    }

    @GetMapping("/hi")
    public HotelPublishRequestDto index1(@RequestBody(required = false) HotelPublishRequestDto student) {
        return student;
    }

    @GetMapping("/h")
    public HotelPublishRequestDto index12(@RequestBody HotelPublishRequestDto student) {
        return student;
    }

    @PostMapping("/hello")
    public HotelPublishRequestDto index(String json) {
        HotelPublishRequestDto hotelPublishRequestDto = JSON.parseObject(json, HotelPublishRequestDto.class);
        return hotelPublishRequestDto;
    }


}
