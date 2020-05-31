package com.huangxw.DesignPattern.mediator;

//具体同事类
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建Alarm同事对象时，将自己放入ConcreteMediator对象中
        mediator.register(name,this);
    }

    public void sendAlarm(int stageChange){
        sendMessage(stageChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        //调用中介者对象的getMessage
        this.getMediator().getMessage(stateChange,this.name);
    }
}
