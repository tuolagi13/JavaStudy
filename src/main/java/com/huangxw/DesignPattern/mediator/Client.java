package com.huangxw.DesignPattern.mediator;

/**
 * 中介者模式
 *需求：智能家居项目，要求主人要看电视时，各个设备可用协同工作，自动完成看电视准备工作
 *      比如流程为：闹铃响起-咖啡机开始做咖啡-窗帘自动落下-电视机开始播放
 *
 * 多个类相互耦合，会形成网状结构，使用中介者模式将网状结构分离为星状结构，进行解耦
 * 相关角色：
 * 1.Mediator是抽象中介者，定义了同事对象到中介者对象的接口
 * 2.Colleague是抽象的同事类(即要管理的所有对象的父类)
 * 3.ConcreteMediator具体的中介者对象，实现抽象方法，它需要知道所有具体同事类
 * (以一个集合管理，并接受某个同事对象的消息，完成相应任务)
 * 4.ConcreteColleague具体同事类，会有很多，每个同事只知道自己的行为，不了解其他同事类行为(方法)
 * 但是他们都依赖中介者对象
 */
public class Client {

    /**
     *中介者模式-创建智能家居流程
     * 1.创建ConcreteMediator对象
     * 2.创建各个同事类对象，比如Alarm、CoffeeMachine、TV
     * 3.在创建同事类对象时，直接通过构造器，加入到colleagueMap
     * 4.同事类对象，可以调用sendMessage，最终会去调用ConcreteMediator的getMessage方法
     * 5.getMessage会根据收到的同事对象的sendMessage来协调其他同事对象，完成任务
     * 6.所以getMessage方法是核心方法
     */
    public static void main(String[] args) {

        //创建一个中介者对象
        Mediator mediator = new ConcreteMediator();

        //创建Alarm 同事对象时，将自己放入concretemediator对象中
        Alarm alarm = new Alarm(mediator,"alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator,"coffeeMachine");
        Curtains curtains = new Curtains(mediator,"curtains");
        TV tv = new TV(mediator,"tv");

        //让闹钟发出消息
        alarm.sendAlarm(0);
        coffeeMachine.FinishCoffee();
        alarm.sendAlarm(1);
    }
}
