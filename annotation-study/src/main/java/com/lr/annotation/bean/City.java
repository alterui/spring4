package com.lr.annotation.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liurui
 * @date 2020/3/20 10:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int id;
    private String name;
}
