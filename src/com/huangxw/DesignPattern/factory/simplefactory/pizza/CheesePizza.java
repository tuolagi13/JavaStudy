package com.huangxw.DesignPattern.factory.simplefactory.pizza;

public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 制作奶酪披萨 准备原材料");
    }
}
