package com.huangxw.DesignPattern.mediator;

public abstract class Mediator {

    //将一个中介者对象加入到集合中
    public abstract void register(String colleagueName,Colleague colleague);
    //接收一个具体同事对象发出的消息
    public abstract void getMessage(int stateChange,String colleagueName);

    public abstract void sendMessage();
}
