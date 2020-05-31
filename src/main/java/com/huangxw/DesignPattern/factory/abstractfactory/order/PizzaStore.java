package com.huangxw.DesignPattern.factory.abstractfactory.order;

/**
 * 抽象工厂模式
 * 定义一个接口，然后让工厂类实现它。
 *
 * 设计模式的依赖抽象原则：
 * 创建对象实例时，不要直接new类，把new的动作放到一个工厂方法中并返回。
 * 不要让类继承具体类，继承抽象类或接口
 */
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza(new LDFactory());
    }
}
