package com.huangxw.DesignPattern.factory.abstractfactory.order;

import com.huangxw.DesignPattern.factory.abstractfactory.pizza.Pizza;
import com.huangxw.DesignPattern.factory.abstractfactory.pizza.BJCheesePizza;
import com.huangxw.DesignPattern.factory.abstractfactory.pizza.BJGreekPizza;

//工厂子类
public class BJFactory implements AbstractFactory {
    @Override
    public Pizza createFactory(String orderType) {
        System.out.println("~~进入抽象工厂模式~~");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
            pizza.setName("北京cheesePizza");
        }else if(orderType.equals("greek")){
            pizza = new BJGreekPizza();
            pizza.setName("北京greekPizza");
        }
        return pizza;
    }
}
