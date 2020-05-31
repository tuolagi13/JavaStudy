package com.huangxw.DesignPattern.factory.abstractfactory.order;

import com.huangxw.DesignPattern.factory.abstractfactory.pizza.Pizza;
import com.huangxw.DesignPattern.factory.abstractfactory.pizza.LDCheesePizza;
import com.huangxw.DesignPattern.factory.abstractfactory.pizza.LDGreekPizza;
//工厂子类
public class LDFactory implements AbstractFactory {

    @Override
    public Pizza createFactory(String orderType) {
        System.out.println("~~进入抽象工厂模式~~");
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
            pizza.setName("伦敦cheesePizza");
        }else if(orderType.equals("greek")){
            pizza = new LDGreekPizza();
            pizza.setName("伦敦greekPizza");
        }
        return pizza;
    }
}
