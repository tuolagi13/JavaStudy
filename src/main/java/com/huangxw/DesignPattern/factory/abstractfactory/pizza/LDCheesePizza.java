package com.huangxw.DesignPattern.factory.abstractfactory.pizza;

public class LDCheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("伦敦的奶酪披萨");
        System.out.println(" 制作伦敦的奶酪披萨 准备原材料");
    }
}
