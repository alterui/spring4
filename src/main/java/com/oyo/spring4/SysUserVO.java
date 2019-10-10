package com.oyo.spring4;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liurui
 * @date 2019/10/10 10:37
 */
@Data
public class SysUserVO implements Serializable {
    private Long id;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String createTime;

    private String userInfo;

    private byte[] headImg;
}
