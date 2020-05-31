package com.huangxw.DesignPattern.factory.simplefactory.order;

import com.huangxw.DesignPattern.factory.simplefactory.pizza.CheesePizza;
import com.huangxw.DesignPattern.factory.simplefactory.pizza.GreekPizza;
import com.huangxw.DesignPattern.factory.simplefactory.pizza.Pizza;

/**
 * 简单工厂类
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        Pizza pizza = null;
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName(orderType);
        } else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
            pizza.setName(orderType);
        }
        return pizza;
    }
}
