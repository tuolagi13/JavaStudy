package com.huangxw.DesignPattern.mediator;

import java.util.HashMap;

//具体中介者对象
public class ConcreteMediator  extends Mediator{

    //集合，放入所有的同事对象
    private HashMap<String,Colleague> colleagueMap;
    private HashMap<String,String> interMap;

    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
        this.interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName,colleague);

        if(colleague instanceof Alarm){
            interMap.put("Alarm",colleagueName);
        }else if(colleague instanceof CoffeeMachine){
            interMap.put("CoffeeMachine",colleagueName);
        }else if(colleague instanceof TV){
            interMap.put("TV",colleagueName);
        }else if(colleague instanceof Curtains){
            interMap.put("Curtains",colleagueName);
        }
    }

    //具体中介者的核心方法
    //1.根据得到的消息，完成对应的任务
    //2.中介者在这个方法，协调各个具体的同事对象，完成任务
    @Override
    public void getMessage(int stateChange, String colleagueName) {

        if(colleagueMap.get(colleagueName) instanceof Alarm)
        {
            if(stateChange == 0)
            {
                ((CoffeeMachine)(colleagueMap.get(interMap.get("CoffeeMachine")))).StartCoffee();
                ((TV)(colleagueMap.get(interMap.get("TV")))).StartTv();
            }
            else if(stateChange == 1)
            {
                ((TV) (colleagueMap.get(interMap.get("TV")))).StopTv();
            }
        }
        else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine)
        {
            ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).UpCurtains();
        }
        else if (colleagueMap.get(colleagueName) instanceof TV)
        {
            ((Curtains) (colleagueMap.get(interMap.get("Curtains")))).UpCurtains();
        }
        else if (colleagueMap.get(colleagueName) instanceof Curtains)
        {
            //如果是以窗帘发出的消息，这里处理...
        }

    }

    @Override
    public void sendMessage() {

    }

}
