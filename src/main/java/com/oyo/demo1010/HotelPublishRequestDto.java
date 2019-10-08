package com.oyo.demo1010;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author liurui
 * @date 2019/10/1 15:10
 */
@Data
public class HotelPublishRequestDto {

    private String oyoId;
    private String hotelName;
    private String channelId;
    private Integer operationType;
    private Integer statusType;
    private Long batchId;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endDate;


}
