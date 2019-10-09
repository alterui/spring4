package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/9 10:59
 */
@Data
public class SysUserRole implements Serializable {
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
}
