package com.huangxw.DesignPattern.factory.abstractfactory.pizza;

public class LDGreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("伦敦的希腊披萨");
        System.out.println(" 制作伦敦的希腊披萨 准备原材料");
    }
}
