package com.oyo.spring4.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/10/8 15:45
 */
@Data
public class Country implements Serializable {
    private Integer id;
    private String countryCode;
    private String countryName;

}
