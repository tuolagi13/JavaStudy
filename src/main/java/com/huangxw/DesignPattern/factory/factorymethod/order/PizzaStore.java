package com.huangxw.DesignPattern.factory.factorymethod.order;


import com.huangxw.DesignPattern.factory.simplefactory.order.OrderPizza;
import com.huangxw.DesignPattern.factory.simplefactory.order.SimpleFactory;

/**
 *现在需求扩展，pizza增加城市分类，可能要点北京的cheesePizza，伦敦的cheesePizza
 * 方法是增加对应工厂子类，如增加BJOrderPizza、LDOrderPizza
 *此即为工厂方法模式
 */
public class PizzaStore {
    public static void main(String[] args) {
        new BJOrderPizza();
    }

}
