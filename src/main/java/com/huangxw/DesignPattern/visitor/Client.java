package com.huangxw.DesignPattern.visitor;

/**
 * 访问者模式
 * 场景：为歌星唱歌打分，观众分为男、女两种
 * 访问者模式角色：
 * 1.Visitor：抽象访问者，为该对象结构的ConcreteElement的每一个类声明一个visit操作
 * 2.ConcreteVisitor：一个具体的访问值，实现每个有Visitor声明的操作，是每个操作实现的部分
 * 3.ObjectStructure：能枚举它的元素，可以提供一个高层的接口，用来允许访问者访问元素
 * 4.Element定义一个accept方法，接收一个访问者对象
 * 5.ConcreteElement：具体元素，实现了accept方法
 */
public class Client {
    public static void main(String[] args) {

        //创建ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        //成功时
        Success success = new Success();
        objectStructure.display(success);
        System.out.println("=====================");
        //失败时
        Fail fail = new Fail();
        objectStructure.display(fail);
    }
}
