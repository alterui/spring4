package com.oyo.spring4.service;

import com.oyo.spring4.po.User;

/**
 * @author liurui
 * @date 2020/3/10 8:07
 */
public interface UserService {
    int insertSelective(User record);
}
