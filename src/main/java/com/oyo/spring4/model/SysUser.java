package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liurui
 * @date 2019/10/9 10:49
 */
@Data
public class SysUser implements Serializable {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 简介
     */
    private String userInfo;

    /**
     * 头像
     */
    private byte[] headImg;

    /**
     * 创建时间
     */
    private Date createTime;

}
