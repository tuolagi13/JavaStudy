package com.huangxw.DesignPattern.factory.abstractfactory.pizza;

public class BJCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("北京的奶酪披萨");
        System.out.println(" 制作北京的奶酪披萨 准备原材料");
    }
}
