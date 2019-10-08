package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/10/3 14:24
 */
@Data
public class HotelDetailsAndChannel {
    private String oyoId;
    private String uniqueCode;
    private String hotelName;
    private List<String> shangjia;
    private List<String> xiajia;


   // private List<OperatorAndChannel> operatorAndChannel;

    public static void main(String[] args) {
        HotelDetailsAndChannel andChannel = new HotelDetailsAndChannel();

        andChannel.setOyoId("234");
        andChannel.setUniqueCode("3242");
        andChannel.setHotelName("掘金");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");





        List<String> collect = list.stream().distinct().collect(Collectors.toList());

        System.out.println(collect);

        andChannel.setXiajia(list);

        andChannel.setShangjia(list);



        String s = JSON.toJSONString(andChannel);

        System.out.println(s);
    }

}
