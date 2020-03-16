package com.oyo.spring4.controller;

import com.oyo.spring4.po.User;
import com.oyo.spring4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author liurui
 * @date 2020/3/10 8:10
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertone")
    @Transactional(rollbackFor = Exception.class)
    public int insertUser() throws IOException {
        User user = new User();
        user.setUsername("today");
        user.setPassword("***");

        int i = userService.insertSelective(user);

        throw new IOException("发生点了异常");


    }

}
