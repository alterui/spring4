package com.oyo.demo.demo0924;

import lombok.AllArgsConstructor;
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
    private final String desc;

    public static String getNameByCode(Integer code) {
        for (AutoReviewStatusEnum statusEnum : values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum.getDesc();
            }
        }

        return null;
    }

    public static AutoReviewStatusEnum parse(String name) {
        for (AutoReviewStatusEnum statusEnum : values()) {
            if (statusEnum.name().equals(name)) {
                return statusEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String nameByCode = getNameByCode(1);
        System.out.println(nameByCode);


        AutoReviewStatusEnum review = parse("TO_REVIEW");
        System.out.println(review.desc);
    }
}
