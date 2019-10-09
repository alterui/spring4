package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/9 11:01
 */
@Data
public class SysPrivilege implements Serializable {
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
}
