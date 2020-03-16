package com.lr.api.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author liurui
 * @date 2020/3/16 8:07
 */
@Data
public class User implements Serializable {

    @NotNull(message = "age不能为空")
    private int age;
    @Length(min = 6,max = 10,message = "名字填写错误")
    private String name;

    @NotBlank(message = "地址不能为空")
    private String address;

    private String phone;

}
