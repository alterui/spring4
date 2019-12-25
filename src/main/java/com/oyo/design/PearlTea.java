package com.oyo.design;

/**
 * @author liurui
 * @date 2019/12/25 12:28
 */
public class PearlTea extends Decorator {
    public PearlTea(Tea tea) {
        super(tea);
    }

    @Override
    protected String doSomething() {
        return null;
    }

    @Override
    protected String getDesc() {
        return super.getDesc()+"  加一点珍珠";
    }

    @Override
    protected int cost() {
        return super.cost()+3;
    }
}
