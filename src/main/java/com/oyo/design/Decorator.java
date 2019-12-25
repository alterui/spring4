package com.oyo.design;

/**
 * @author liurui
 * @date 2019/12/25 12:25
 */
public abstract class Decorator extends Tea {

    private Tea tea;

    public Decorator(Tea tea) {
        this.tea = tea;
    }

    protected abstract String doSomething();

    @Override
    protected String getDesc() {
        return this.tea.getDesc();
    }

    @Override
    protected int cost() {
        return this.tea.cost();
    }
}
