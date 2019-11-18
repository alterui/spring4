package com.oyo.demo.demo1010;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author liurui
 * @date 2019/10/10 14:55
 */
public class Application {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        ChannelBO channelBO = new ChannelBO();

        channelBO.setPutWay(Lists.newArrayList());

        System.out.println(channelBO.getPutWay()+"+++++++++++++");

    }
}
