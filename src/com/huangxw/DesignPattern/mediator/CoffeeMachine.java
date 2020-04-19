package com.huangxw.DesignPattern.mediator;

public class CoffeeMachine extends Colleague{

    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    public void StartCoffee() {
        System.out.println("It's time to startcoffee!");
    }
    public void FinishCoffee() {
        System.out.println("After 5 minutes!");
        System.out.println("Coffee is ok!");
        sendMessage(0);
    }


    @Override
    public void sendMessage(int stateChange) {
        //调用中介者对象的getMessage
        this.getMediator().getMessage(stateChange,this.name);
    }
}
