package com.oyo.spring4.controller.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/8 16:16
 */
@Data
public class CountryReq implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
}
