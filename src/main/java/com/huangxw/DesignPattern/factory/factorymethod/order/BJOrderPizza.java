package com.huangxw.DesignPattern.factory.factorymethod.order;

import com.huangxw.DesignPattern.factory.factorymethod.pizza.BJCheesePizza;
import com.huangxw.DesignPattern.factory.factorymethod.pizza.BJGreekPizza;
import com.huangxw.DesignPattern.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
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
