package com.huangxw.DesignPattern.template;

/**
 * 模板方法模式
 * AbstractClass：用抽象方法定义算法的骨架，具体子类实现
 * ConcreteClass：实现抽象方法
 * 案例：制作豆浆流程
 */
public class Client {
    public static void main(String[] args) {

        //制作红豆豆浆
        System.out.println("-----制作红豆豆浆-----");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();

        //制作纯豆浆
        System.out.println("-----制作纯豆浆-----");
        SoyaMilk pure = new PureSoyaMilk();
        pure.make();
    }
}
