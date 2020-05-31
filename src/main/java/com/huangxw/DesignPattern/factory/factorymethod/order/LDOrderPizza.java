package com.huangxw.DesignPattern.factory.factorymethod.order;

import com.huangxw.DesignPattern.factory.factorymethod.pizza.*;

public class LDOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
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
