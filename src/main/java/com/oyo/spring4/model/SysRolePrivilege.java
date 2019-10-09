package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/9 11:04
 */
@Data
public class SysRolePrivilege implements Serializable {
    private Long roleId;
    private Long privilegeId;
}
