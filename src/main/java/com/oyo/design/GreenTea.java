package com.oyo.design;

/**
 * @author liurui
 * @date 2019/12/25 12:23
 */
public class GreenTea extends Tea {
    @Override
    protected String getDesc() {
        return "这个是绿茶";
    }

    @Override
    protected int cost() {
        return 3;
    }
}
