package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.oyo.spring4.SysUserVO;
import com.oyo.spring4.aop.ExceptionCatch;
import com.oyo.spring4.client.Animal;
import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.mapper.StudentMapper;
import com.oyo.spring4.mapper.SysUserMapper;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;
import com.oyo.spring4.po.Student;
import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.po.SysUser;
import com.oyo.spring4.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/10/8 15:57
 */
@RestController
@Slf4j
public class StudentController {

    @Resource
    private StudentMapper studentMapper;

    @PostMapping("/getStudent")
    public Student getStudent(@RequestParam Integer id,@RequestBody Student student) {
        System.out.println(student);
        return studentMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/getStudentList")
    public Map<Integer, Student> getAllStudentList() {
        List<Student> studentList = studentMapper.getAllStudentList();
        studentList.forEach(System.out::println);
        Map<Integer, Student> collect = studentList.stream().collect(Collectors.toMap(Student::getStudentAge, Function.identity(),(e,h)-> e));

        collect.forEach((e,h)-> System.out.println(e));
        return collect;

    }

    /**
     * 使用@PostConstruct注解会在Servlet初始化的时候执行
     */
    @PostConstruct
    public void init1() {
        System.out.println("init方法执行了" + new Date());
    }

    /**
     * 使用@PreDestroy注解会在servlet销毁后执行
     */
    @PreDestroy
    public void destroy2() {
        System.out.println("destroy方法执行了" + new Date());
    }





}
