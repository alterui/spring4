package com.oyo.demo.demo0925;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.oyo.common.BaseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/9/25 11:09
 */
public class Application {
    public static void main(String[] args) {
        List<OtaDltChannelDto> otaDltChannelDtoList = new ArrayList<>();

        OtaDltChannelDto otaDltChannelDto =  new OtaDltChannelDto();
        otaDltChannelDto.setChannelId(1L);
        otaDltChannelDto.setChannelName("oyo");

        OtaDltChannelDto otaDltChannelDto1 =  new OtaDltChannelDto();
        otaDltChannelDto1.setChannelId(1L);
        otaDltChannelDto1.setChannelName("oyo1");

        otaDltChannelDtoList.add(otaDltChannelDto);
        otaDltChannelDtoList.add(otaDltChannelDto1);

        Map<Long, OtaDltChannelResponse> collect = otaDltChannelDtoList.stream()
                .collect(Collectors.toMap(OtaDltChannelDto::getChannelId, OtaDltChannelResponse::from,
                (a, b) -> {
                    a.getChannelNameList().addAll(b.getChannelNameList());
                    return a;
                }));



        Map<Long, List<OtaDltChannelDto>> collect1 = otaDltChannelDtoList.stream().collect(Collectors.groupingBy(OtaDltChannelDto::getChannelId));

        OtaDltChannelResponse otaDltChannelResponse = new OtaDltChannelResponse();


        otaDltChannelResponse.setChannelNameList(Lists.newArrayList());
        collect1.forEach((k,v)->
                v.forEach(e->{
            otaDltChannelResponse.getChannelNameList().add(e.getChannelName());
        }));

        otaDltChannelResponse.getChannelNameList().forEach(System.out::println);

        OtaDltChannelRequest otaDltChannelRequest = new OtaDltChannelRequest();

        BeanUtils.copyProperties(otaDltChannelResponse, otaDltChannelRequest);

        System.out.println("+++++++++++++");
        otaDltChannelRequest.getChannelNameList().forEach(System.out::print);



    }
}
