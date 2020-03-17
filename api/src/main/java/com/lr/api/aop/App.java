package com.lr.api.aop;

import com.lr.api.bean.User;

/**
 * @author liurui
 * @date 2020/3/17 13:15
 */
public class App {
    public static void main(String[] args) {
        User user = new User(1, "3");
        User user1 = new User(1, "323");

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
    }
}


