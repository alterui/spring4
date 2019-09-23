package com.oyo.car;

/**
 * @author liurui
 * @date 2019/9/20 18:43
 */
public class GetBMWCat implements GetCar {
    @Override
    public void getCar() {
        Integer a = 0;
        Integer b = null;

        try {
            int c = a+b;
        } catch (Exception e) {
            throw new RuntimeException("json属性不能为空");
        }
    }
}
