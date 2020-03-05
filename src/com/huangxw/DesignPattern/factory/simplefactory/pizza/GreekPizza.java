package com.huangxw.DesignPattern.factory.simplefactory.pizza;

public class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println(" 制作希腊披萨 准备原材料");
    }
}
