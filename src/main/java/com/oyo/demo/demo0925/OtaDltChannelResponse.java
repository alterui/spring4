package com.oyo.demo.demo0925;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/12/3 11:52
 */
@Data
public class OtaDltChannelResponse implements Serializable {
    /**
     * 渠道id
     */
    private Long channelId;

    /**
     * 渠道名称
     */
    private List<String> channelNameList;

    public static OtaDltChannelResponse from(OtaDltChannelDto otaDltChannelDto) {
        OtaDltChannelResponse otaDltChannelResponse = new OtaDltChannelResponse();
        otaDltChannelResponse.setChannelId(otaDltChannelDto.getChannelId());
        otaDltChannelResponse.setChannelNameList(new ArrayList<>());
        otaDltChannelResponse.getChannelNameList().add(otaDltChannelDto.getChannelName());
        return otaDltChannelResponse;

    }
}
