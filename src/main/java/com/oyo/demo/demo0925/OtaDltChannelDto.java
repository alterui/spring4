package com.oyo.demo.demo0925;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/12/2 15:38
 */
@Data
public class OtaDltChannelDto implements Serializable {
    /**
     * 渠道id
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private String channelName;
}
