package com.huangxw.DesignPattern.factory.simplefactory.order;



/**
 * 相当于客户端，发出订购任务
 *
 * 以下相当于传统方式完成订购pizza任务
 * 缺点：
 * 违反ocp原则，即（服务端）对扩展开放，（客户端）对修改关闭
 * 加入我们增加一个新的pizza种类，新增PepperPizza类没问题，对OrderPizza做修改有问题
 * OrderPizza相当于客户端，可能有很多个OrderPizza都要做修改
 *
 * 简单工厂模式改进思路：
 * 把创建Pizza对象逻辑封装到一个类中，这样有新的Pizza种类时，只需要修改该类即可
 */
public class PizzaStore {
    public static void main(String[] args) {
        //new OrderPizza();

        //使用简单工厂模式
        new OrderPizza(new SimpleFactory());
    }

}
