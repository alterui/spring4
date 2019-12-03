package com.oyo.demo.demo0925;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liurui
 * @date 2019/12/3 15:52
 */
@Data
public class OtaDltChannelRequest implements Serializable {
    /**
     * 渠道id
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private List<String> channelNameList;
}
