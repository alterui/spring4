package com.oyo.design;

/**
 * @author liurui
 * @date 2019/12/25 12:30
 */
public class Test {
    public static void main(String[] args) {
        Tea tea = new GreenTea();
        tea = new PearlTea(tea);

        System.out.println(tea.getDesc() + ",销售价格：" + tea.cost());
    }
}
