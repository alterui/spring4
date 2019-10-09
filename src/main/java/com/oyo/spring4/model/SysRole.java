package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liurui
 * @date 2019/10/9 11:02
 */
@Data
public class SysRole implements Serializable {
    private Long id;
    private String roleName;
    private Integer enabled;
    private Long createBy;
    private Date createTime;
}
