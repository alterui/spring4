package com.oyo.spring4.service.impl;

import com.oyo.spring4.mapper.UserMapper;
import com.oyo.spring4.po.User;
import com.oyo.spring4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liurui
 * @date 2020/3/10 8:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertSelective(User record) {

      return userMapper.insertSelective(record);


    }
}
