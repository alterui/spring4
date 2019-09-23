package com.oyo.bike;

/**
 * @author liurui
 * @date 2019/9/20 18:32
 */
public class getHelloBike implements GetBike {
    @Override
    public void getBike() {
        Integer a = 0;
        Integer b = null;

        try {
            int c = a+b;
        } catch (Exception e) {
            throw new RuntimeException("json属性不能为空");
        }
    }
}
