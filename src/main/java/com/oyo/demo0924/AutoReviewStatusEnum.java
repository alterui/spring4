package com.oyo.demo0924;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author liurui
 * @date 2019/9/24 11:22
 */

@AllArgsConstructor
@Getter
public enum AutoReviewStatusEnum {

    TO_REVIEW(0, "待审核"),
    REVIEWING(1,"审核中")
    ;

    private final Integer code;
    private final String name;
}
