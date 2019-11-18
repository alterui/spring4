package com.oyo.demo.demo1010;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;

/**
 * @author liurui
 * @date 2019/10/1 15:11
 */
public class Main {

    //private static Object HotelPublishRequestDto;

    public static void main(String[] args) {
        String Json = " {\n" +
                "    \"hotelName\":\"龙湖宾馆\",\n" +
                "     \"otaCode\":\"\",\n" +
                "    \"status\":\"1\",\n" +
                "    \"batchId\":\"101\",\n" +
                "    \"beginDate\":\"2019-09-30 14:30:00\",\n" +
                "    \"endDate\":\"2019-09-30 14:30:00\"\n" +
                "}\n" +
                "\n";

        HotelPublishRequestDto hotelPublishRequestDto = JSON.parseObject(Json, HotelPublishRequestDto.class);
//        if (StringUtils.isEmpty(hotelPublishRequestDto.getOtaCode())) {
//            System.out.println(hotelPublishRequestDto.getOtaCode());
//            System.out.println("mm");
//        }

        System.out.println(hotelPublishRequestDto);

        System.out.println("==============");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //String format = simpleDateFormat.format(hotelPublishRequestDto.getBeginDate());

        //new Data(hotelPublishRequestDto.getBeginDate());


    }
}
