package com.huangxw.DesignPattern.factory.abstractfactory.pizza;

public class BJGreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("北京的希腊披萨");
        System.out.println(" 制作北京的希腊披萨 准备原材料");
    }
}
