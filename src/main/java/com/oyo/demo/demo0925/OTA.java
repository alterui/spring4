package com.oyo.demo.demo0925;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liurui
 * @date 2019/12/2 18:37
 */
@Data
public class OTA implements Serializable {
    private Integer id;
    private Integer name;

    private List<OtaDltChannelDto> otaDltChannelDtoList;

}
