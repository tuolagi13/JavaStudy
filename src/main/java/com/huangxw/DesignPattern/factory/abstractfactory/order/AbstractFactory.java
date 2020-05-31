package com.huangxw.DesignPattern.factory.abstractfactory.order;

import com.huangxw.DesignPattern.factory.abstractfactory.pizza.Pizza;

//一个抽象工厂模式的抽象层(接口)
public interface AbstractFactory {
    //让工厂子类具体实现
    Pizza createFactory(String orderType);
}
